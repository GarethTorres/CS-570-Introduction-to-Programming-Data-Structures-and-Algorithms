public class IDLListTest {
    /* Create a new IDLList and test with inputs. */
    public static void main(String[] args) {

        IDLList<String> a = new IDLList<String>();

        a.add("Blue");
        a.add("Red");
        a.add("Yellow");
        a.add("Purple");
        a.add("White");
        a.add("Black");
        a.add("Pink");
        a.add("Green");
        System.out.println("testing IDLList:");
        a.toString();

        System.out.println("Add Gray at index 1:" + a.add(1, "Gray"));
        a.toString();

        System.out.println("Add Brown at index 2:" + a.add(2, "Brown"));
        a.toString();

        System.out.println("Add maroon at last index:" + a.add(a.size() - 1, "maroon"));
        a.toString();

        System.out.println("Append Scarlet at the IDLList:" + a.append("Scarlet"));
        a.toString();

        System.out.println("Index 2 is " + a.get(2));

        System.out.println("The head of IDLList is:" + a.getHead());

        System.out.println("The tail of IDLList is:" + a.getLast());

        System.out.println("The size of IDLList is:" + a.size());

        System.out.println("Remove():" + a.remove());
        a.toString();

        System.out.println("RemoveLast():" + a.removeLast());
        a.toString();

        System.out.println("removeAt(4):" + a.removeAt(4));
        a.toString();

        System.out.println("Remove('Black'):" + a.remove("Black"));
        a.toString();

        System.out.println("Remove('NotExisting'):" + a.remove("NotExisting"));
        a.toString();

    }
}