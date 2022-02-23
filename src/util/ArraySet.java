/*
 * File: ArraySet.java
 * Creator: George Ferguson
 * Created: Tue Mar 15 16:33:49 2011
 * Time-stamp: <Thu Mar 15 12:20:55 EDT 2012 ferguson>
 */

package util;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * A Set implementation backed by an ArrayList.
 * This is good for more or less immutable sets, but isn't part of
 * standard Java.
 */
public class ArraySet<E> extends AbstractSet<E> {

    protected ArrayList<E> elements;

    /**
     * Construct and return a new ArraySet with some default
     * initial capacity (in fact, the default initial capacity of
     * an ArrayList, if you care).
     */
    public ArraySet() {
	super();
	elements = new ArrayList<E>();
    }

    /**
     * Construct and return a new ArraySet with the given
     * initial capacity.
     */
    public ArraySet(int initialCapacity) {
	super();
	elements = new ArrayList<E>(initialCapacity);
    }

    /**
     * Construct and return a new ArraySet containing the elements
     * of the given collection and with capacity as needed to whole
     * them all. Per the contract of the Set interface in the Collections
     * Framework, duplicate elements (according to equals()) are not added
     * mulitple times.
     */
    public ArraySet(Collection<? extends E> c) {
	this(c.size());
	for (E e : c) {
	    add(e);
	}
    }

    /**
     * Returns an iterator over the elements in this ArraySet.
     */
    public Iterator<E> iterator() {
	return elements.iterator();
    }

    /**
     * Returns the number of elements in this ArraySet (its cardinality).
     */
    public int size() {
	return elements.size();
    }

    /**
     * Adds the specified element to this ArraySet if it is not already present.
     * Returns true if the element was added, else false.
     */
    public boolean add(E e) {
	if (contains(e)) {
	    return false;
	} else {
	    return elements.add(e);
	}
    }

}
