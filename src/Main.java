 public class Main {
        public static void main(String[] args) {
            IntOnlyArrayList il = new IntOnlyArrayList();

            //tilføjer nogle tal til arrayet
            il.add(5);
            il.add(14);
            il.add(67);

            System.out.println(il);
            //tester remove
            il.remove(1);

            //Tester print
            System.out.println(il);

            //tester clear
            il.clear();
            System.out.println("Clear:\n"+il);
        }
}
