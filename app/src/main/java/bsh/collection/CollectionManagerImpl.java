package bsh.collection;

import java.util.Iterator;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.lang.reflect.Array;
import bsh.BshIterator;

/**
	Dynamically loaded extension supporting post 1.1 collections iterator.
 	@author Pat Niemeyer
 */
public class CollectionManagerImpl extends bsh.CollectionManager
{
	public BshIterator getBshIterator( Object obj ) 
		throws IllegalArgumentException
	{
		return new CollectionIterator( obj ); 
	}

	public boolean isMap( Object obj ) 
	{
		if ( obj instanceof Map )
			return true;
		else
			return super.isMap( obj );
	}

	public Object getFromMap( Object map, Object key ) 
	{
		// Hashtable implements Map
		return ((Map)map).get(key);
	}

	/*
	  	Place the raw value into the map... should be unwrapped.
	 */
	public Object putInMap( Object map, Object key, Object value ) 
	{
		// Hashtable implements Map
		return ((Map)map).put(key, value);
	}
}
