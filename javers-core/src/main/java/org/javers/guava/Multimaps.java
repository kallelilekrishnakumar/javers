package org.javers.guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import org.javers.common.collections.Sets;

import java.util.Collections;
import java.util.Set;

/**
 * @author akrystian
 */
class Multimaps{
    /**
     * null args are allowed
     */
    public static <K, V> Set<K> commonKeys(Multimap<K, V> left, Multimap<K, V> right){
        if (left == null || right == null) {
            return Collections.emptySet();
        }

        return Sets.intersection(left.keySet(), right.keySet());
    }

    /**
     * null args are allowed
     */
    public static <K, V> Set<K> keysDifference(Multimap<K, V> left, Multimap<K, V> right){
        if (left == null){
            return Collections.emptySet();
        }

        if (right == null){
            return left.keySet();
        }

        return Sets.difference(left.keySet(), right.keySet());
    }

    public static Multimap createEmptyMultimap(Object sourceMap){
        if(sourceMap instanceof ListMultimap){
            return ArrayListMultimap.create();
        }else {
            return  HashMultimap.create();
        }
    }

    public static Multimap toNotNullMultimap(Object sourceMap){
        if (sourceMap == null){
            return ArrayListMultimap.create();
        }else{
            return (Multimap) sourceMap;
        }
    }
}

