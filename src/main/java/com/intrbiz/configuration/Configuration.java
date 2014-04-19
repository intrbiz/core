package com.intrbiz.configuration;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.intrbiz.Util;

/**
 * Configuration for a component of any application or framework.
 */
@XmlType(name = "configuration")
@XmlRootElement(name = "configuration")
public class Configuration
{
    private String name;

    private String classname;

    private List<CfgParameter> parameters = new LinkedList<CfgParameter>();

    public Configuration()
    {
    }

    public void applyDefaults()
    {
    }

    @XmlAttribute(name = "name")
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @XmlAttribute(name = "classname")
    public String getClassname()
    {
        return Util.isEmpty(this.classname) ? this.defaultClassname() : this.classname;
    }

    protected String defaultClassname()
    {
        return null;
    }

    public void setClassname(String classname)
    {
        this.classname = classname;
    }

    @XmlElementRef(type = CfgParameter.class)
    public List<CfgParameter> getParameters()
    {
        return this.parameters;
    }

    public void setParameters(List<CfgParameter> parameters)
    {
        this.parameters = parameters;
    }

    public void addParameter(CfgParameter p)
    {
        this.parameters.add(p);
    }

    public CfgParameter getParameter(String name)
    {
        for (CfgParameter p : this.getParameters())
        {
            if (name.equals(p.getName())) return p;
        }
        return null;
    }

    public String getStringParameterValue(String name, String def)
    {
        CfgParameter p = this.getParameter(name);
        if (p == null) return def;
        return p.getValue();
    }

    public int getIntParameterValue(String name, int def)
    {
        CfgParameter p = this.getParameter(name);
        if (p == null) return def;
        try
        {
            return Integer.parseInt(p.getValue());
        }
        catch (NumberFormatException e)
        {
            return def;
        }
    }

    public long getLongParameterValue(String name, long def)
    {
        CfgParameter p = this.getParameter(name);
        if (p == null) return def;
        try
        {
            return Long.parseLong(p.getValue());
        }
        catch (NumberFormatException e)
        {
            return def;
        }
    }

    public float getFloatParameterValue(String name, float def)
    {
        CfgParameter p = this.getParameter(name);
        if (p == null) return def;
        try
        {
            return Float.parseFloat(p.getValue());
        }
        catch (NumberFormatException e)
        {
            return def;
        }
    }

    public double getDoubleParameterValue(String name, double def)
    {
        CfgParameter p = this.getParameter(name);
        if (p == null) return def;
        try
        {
            return Double.parseDouble(p.getValue());
        }
        catch (NumberFormatException e)
        {
            return def;
        }
    }

    public boolean getBooleanParameterValue(String name, boolean def)
    {
        CfgParameter p = this.getParameter(name);
        if (p == null) return def;
        try
        {
            return Boolean.parseBoolean(p.getValue());
        }
        catch (NumberFormatException e)
        {
            return def;
        }
    }

    /**
     * Create and configure the object represented by this configuration
     * 
     * @return
     * @throws IntrbizException
     *             returns Object
     */
    @SuppressWarnings("unchecked")
    public Object create() throws Exception
    {
        Class<?> cls = Class.forName(this.getClassname());
        Object obj = (Object) cls.newInstance();
        if (obj instanceof Configurable<?>) ((Configurable<Configuration>) obj).configure(this);
        return obj;
    }

    public void copyTo(Configuration cfg)
    {
        cfg.setName(this.getName());
        cfg.setClassname(this.getClassname());
        for (CfgParameter p : this.getParameters())
        {
            cfg.addParameter(new CfgParameter(p.getName(), p.getDescription(), p.getValue()));
        }
    }

    public static Configuration read(Class<?>[] types, InputStream in) throws JAXBException
    {
        JAXBContext ctx = JAXBContext.newInstance(types);
        return (Configuration) ctx.createUnmarshaller().unmarshal(in);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Configuration> T read(Class<T> type, InputStream in) throws JAXBException
    {
        return (T) read(new Class<?>[] { type }, in);
    }

    public static void write(Class<?>[] types, Configuration obj, OutputStream out) throws JAXBException
    {
        JAXBContext ctx = JAXBContext.newInstance(types);
        Marshaller m = ctx.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(obj, out);
    }

    public static void write(Class<?> type, Configuration obj, OutputStream out) throws JAXBException
    {
        write(new Class<?>[] { type }, obj, out);
    }

    public String toString()
    {
        try
        {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            write(this.getClass(), this, baos);
            return new String(baos.toByteArray());
        }
        catch (Exception ie)
        {
        }
        return super.toString();
    }
}
