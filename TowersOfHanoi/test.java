import java.util.*;

class test {


  public static void main(String[] args) {


  // int yerp = 0;
  // int derp = 1;
  // int hive = 0;
  //
  // System.out.println("0 & 1 was : " + hai(yerp, derp));
  // System.out.println("1 & 0 was : " + hai(derp, yerp));
  // System.out.println("0 & 0 was : " + hai(yerp, hive));

    Stack<Integer> testy1 = new Stack<Integer>();
    Stack<Integer> testy2 = new Stack<Integer>();
    Stack<Integer> testy3 = new Stack<Integer>();

    for (int i = 10; i > 0; i--) {
      testy1.push(i);
      testy2.push(i+10);
      testy3.push(i+20);
    }

    String testy = Arrays.toString(testy1.toArray());
    String next = Arrays.toString(testy1.toArray());

    System.out.println(testy);
    System.out.println(next);
    System.out.println(next.equals(testy));
    // System.out.println(testy1.size());
    // for (int i = testy1.size(); i > 0; i--){
    //   System.out.println("testy1 : " + testy1.pop() + "\t" + "Size = " + testy1.size());
    // }

    // for (int i = 10; i > 0; i--) {
    //   testy1.push(i);
    // }

    // System.out.println("peeking" + testy1.peek());
    // int[] i = new int[testy1.size()];
    // for (int k = 0; k < i.length; k++) {
    //   i[k] = testy1.pop();
    // }
    // for (int each : i) {
    //   System.out.println("each in i : " + each);
    // }
    // for (int k = i.length-1; k >=0; k--) {
    //   testy1.push(i[k]);
    // }
    // for (int k = 0; k < 10; k++) {
    //   System.out.println(testy1.pop());
    // }



    // System.out.println(Arrays.toString(testy1.toArray()));
    // for (int i : testy1) {
    //   System.out.println("core case : " + i);
    // }
    // ListIterator itty1 = testy1.listIterator(testy1.size());
    // ListIterator itty2 = testy2.listIterator(testy2.size());
    // ListIterator itty3 = testy3.listIterator(testy3.size());
    // System.out.println(String.format("%10s","Stack 1") + String.format("%10s","Stack 2") + String.format("%10s","Stack 3"));
    // System.out.println();
    // ListIterator [] arr = {itty1, itty2, itty3};
    // int counter = 1;
    // while (counter <= 11/**itty1.hasPrevious()*/) {
    //   for (ListIterator each : arr) {
    //     if (each.hasPrevious()) System.out.print(String.format("%10s",each.previous()));
    //     else System.out.print(String.format("%10s",""));
    //   }
    //   System.out.println();
    //   counter++;
    // }

    // testy3.push(testy1.pop());
    // itty1 = testy1.listIterator(testy1.size());
    // itty2 = testy2.listIterator(testy2.size());
    // itty3 = testy3.listIterator(testy3.size());
    // System.out.println("test 2" + String.format("%10s","Stack 1") + String.format("%10s","Stack 2") + String.format("%10s","Stack 3"));
    // System.out.println();
    // ListIterator [] arr2 = {itty1, itty2, itty3};
    // // int counter = 1;
    // counter = 0;
    // while (counter <= 11) {
    //   for (ListIterator each : arr2) {
    //     if (each.hasPrevious()) System.out.print(String.format("%10s",each.previous()));
    //     else System.out.print(String.format("%10s",""));
    //   }
    //   System.out.println();
    //   counter++;
    // }
    // for (int i = 0 ; i < 11 ; i++){
    //   System.out.println(testy1.pop());
    // }
  }
}
