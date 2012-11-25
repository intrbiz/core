package com.intrbiz.util.uuid;

import java.net.NetworkInterface;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.UUID;

public final class UUIDFactory
{
    private static final UUIDFactory us = new UUIDFactory();

    public static final UUIDFactory getInstance()
    {
        return us;
    }

    private final long machine;

    private SecureRandom random;

    private volatile short sequence;

    private final Object sequenceLock;

    private UUIDFactory()
    {
        this.machine = initMachine() & 0xFFFFFFFFFFFFL;
        this.random = new SecureRandom();
        this.sequenceLock = new Object();
        this.sequence = 0;
    }

    private long initMachine()
    {
        Long ret = Long.getLong("com.intrbiz.uuid.machine");
        if (ret == null)
        {
            try
            {
                Enumeration<NetworkInterface> i = NetworkInterface.getNetworkInterfaces();
                while (i.hasMoreElements())
                {
                    NetworkInterface ni = i.nextElement();
                    ret = 0L;
                    for (byte b : ni.getHardwareAddress())
                    {
                        ret <<= 8;
                        ret ^= (long) (b & 0xFF);
                    }
                    break;
                }
            }
            catch (Exception e)
            {
                ret = 0xFFFFFFFFFFFFFFFFL;
            }
        }
        return ret;
    }

    private short getNextSequenceNumber()
    {
        synchronized (this.sequenceLock)
        {
            if (this.sequence >= 0xCF) this.sequence = 0;
            this.sequence++;
            return this.sequence;
        }
    }

    private int getRandom()
    {
        return this.random.nextInt();
    }

    private long getTime()
    {
        return System.currentTimeMillis();
    }

    public UUID generate()
    {
        long time = this.getTime();
        long rand = this.getRandom();
        long seq = this.getNextSequenceNumber();
        long mac = this.machine;
        /*
         * 8 7 6 5 4 3 2 1 0xFF FF FF 00 00 00 00 00 random 0x00 00 00 FF FF FF 00 00 time_hi 0x00 00 00 00 00 00 F0 00 version 0x00 00 00 00 00 00 0F FF time_lo
         */
        long msb = 0x0000000000004000L;
        msb |= (rand << 32) & 0xFFFFFF0000000000L;
        msb |= (time >> 4) & 0x000000FFFFFF0000L;
        msb |= (time >> 4) & 0x0000000000000FFFL;
        /*
         * 8 7 6 5 4 3 2 1 0xC0 00 00 00 00 00 00 00 variant 0x3F FF 00 00 00 00 00 00 seq 0x00 00 FF FF FF FF FF FF machine
         */
        long lsb = 0xC000000000000000L;
        lsb |= (seq & 0x3FFF) << 48;
        lsb |= mac;
        return new UUID(msb, lsb);
    }

    public long getMachine()
    {
        return machine;
    }

    public static UUID uuid()
    {
        return UUIDFactory.getInstance().generate();
    }
}
