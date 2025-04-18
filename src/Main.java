public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArray = new MyArrayList<>();
        myArray.add(1);
        myArray.add(2);
        myArray.add(3);
        myArray.add(4);
        myArray.add(5);
        myArray.add(6);
        myArray.remove(5);
        myArray.add(2, 10);
        myArray.addFirst(0);
        myArray.addLast(7);
        myArray.sort(Integer::compareTo);
        for (int i = 0; i < myArray.size(); i++) {
            System.out.print(myArray.get(i)+" ");
        }
        System.out.println("\n"+"+++++++++++++++++++++++");

        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        myLinkedList.add(6);
        myLinkedList.remove(5);
        System.out.println(myLinkedList.size());

        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.print(myLinkedList.get(i)+" ");
        }

    }
    }
