package Hw3_21000663_NguyenNgocAnh.Exercise03;

public class Test {
    public static void main(String[] args) {
        // Test 
        SimpleLinkedList<String> list = new SimpleLinkedList<>();

        // add
        list.add("afdg");
        list.add("sfghsb");
        list.add("cgjsr");
        list.add("drty");

        // print
        System.out.println("List:" + list);

        // size
        System.out.println("Size:" + list.size());

        // get
        System.out.println("Get (3):" + list.get(3));

        // set
        list.set(3, "ertwt");
        System.out.println("After set (3, \"ertwt\"):" + list);

        // isContain
        System.out.println("Is contain (cgjsr):" + list.isContain("cgjsr"));

        // remove top
        System.out.println("Remove top: " + list.removeTop() + "\n" + "After remove top:" + list);
        
        // remove
        list.remove("cgjsr");
        System.out.println("After remove (cgjsr):" + list);

        // remove bot
        System.out.println("Remove bot: " + list.removeBot() + "\n" + "After remove bot:" + list);
        
        // isEmpty
        System.out.println("Is empty:" + list.isEmpty());
        
        // add bot
        list.addBot("sdfgrt");
        System.out.println("After add bot (sdfgrt):" + list);

        // add
        list.add("Anne");
        System.out.println("After add (Anne):" + list);
    }
}
// List:[afdg, sfghsb, cgjsr, drty]
// Size:4
// Get (3):drty
// After set (3, "ertwt"):[afdg, sfghsb, cgjsr, ertwt]
// Is contain (cgjsr):true
// Remove top: afdg
// After remove top:[sfghsb, cgjsr, ertwt]
// After remove (cgjsr):[sfghsb, ertwt]
// Remove bot: ertwt
// After remove bot:[sfghsb]
// Is empty:false
// After add bot (sdfgrt):[sfghsb, sdfgrt]
// After add (Anne):[sfghsb, sdfgrt, Anne]
