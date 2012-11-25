package com.intrbiz.collections;

/**
 * Callback interface to mapping a collection of things to another collection of things
 */
public interface Mapping<I, O>
{
    /**
     * Map an object from something to something else
     * @param input
     * @return
     * returns O
     */
    public O map(I input);
}
