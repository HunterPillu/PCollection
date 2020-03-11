package com.altran.pList;

import com.altran.User;

public class ArrayListImpl {
    public void main(){
        PArrayList<Integer> pArrayList = new PArrayList<Integer>();
        for (int i = 0; i < 12; i++) {
            pArrayList.add(i);
        }
        System.out.println(pArrayList.toString());

        // pArrayList.remove(5);
        // System.out.println(pArrayList.toString());

        //pArrayList.remove(-2);

        for (int i = 0; i < 12; i++) {

            pArrayList.remove(pArrayList.size() - 1);

        }
        System.out.println(pArrayList.toString());
        PArrayList<User> al = new PArrayList<>(10);
        al.add(new User("asdf", 45));
        al.add(new User("asdf", 47));
        //System.out.println(al.toString());

        User u = new User("asdfae", 48);

        al.add(0, new User("asdfae", 46));
        //System.out.println(al.toString());

        al.add(2, u);
        //System.out.println(al.toString());

        al.add(3, new User("asdfae", 48));
        //System.out.println(al.toString());

        PArrayList<User> al2 = new PArrayList<>(al);
        PArrayList<User> al3 = new PArrayList<>();
        //al2.addAll(al);
        al2.add(new User("asdfae", 148));
        System.out.println(al2.toString());
        System.out.println("--------------");
        System.out.println(al2.contains(al.get(2)));
        System.out.println("--------------");

        System.out.println(al.containsAll(al2));
        System.out.println(al2.removeAll(al3));
        System.out.println(al2.toString());
    }
}
