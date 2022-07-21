package LibraryManagementSystem;

import java.io.*;

class category extends Main{
        String book_name,isbn,author_name,price;
        int book_count;
        public void show(String category_name){
                try {
                        String s;
                        FileReader fr = new FileReader(category_name+".txt");
                        BufferedReader br = new BufferedReader(fr);
                        while ((s = br.readLine()) != null) {
                                System.out.println(s);
                        }
                }
                catch (IOException e){
                        e.printStackTrace();
                }
                return;
        }

}
public class Management extends Main {
        public void show() {
                int choice2;
                System.out.println("1.FICTION\n2.NON-FICTION\nEnter Your Choice : ");
                choice2 = sc.nextInt();
                category c = new category();
                if (choice2 == 1) {
                        c.show("Fiction");
                } else {
                        c.show("Non-Fiction");
                }
                System.out.println();
        }
}



