package com.none.algorithms.sort;

public abstract class SortTemplate {

    public abstract void sort(Comparable[] a);

    public static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }

    public static void exchange(Comparable[] a,int i,int j){
        Comparable comparable = a[i];
        a[i] = a[j];
        a[j] = comparable;
    }

    public static void show(Comparable[] a){
        if (a!=null&&a.length>0){
            for (Comparable comparable:a){
                System.out.println(comparable + " ");
            }
        }
    }

    public static boolean isSorted(Comparable[] a){
        for (int i=1;i<a.length;i++){
            if (less(a[i],a[i-1])) return false;
        }
        return true;
    }
}
