package LibraryManagementSystem;

import java.io.*;

public class Book extends category{
    String category_name;
    String[][] bookDetails=new String[11][6];
    Book(){
        try {
            String s;
            int row = 0;
            FileReader fr = new FileReader("Book.txt");
            BufferedReader br = new BufferedReader(fr);
            while ((s = br.readLine()) != null) {
                this.bookDetails[row] = s.split(",");
                row++;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void setData(String book_name,String author_name,String isbn,String price,String category_name,int book_count){
        this.book_name=book_name;
        this.author_name=author_name;
        this.price=price;
        this.isbn=isbn;
        this.category_name=category_name;
        this.book_count=book_count;
    }
    int traverse(int n,String str){
        for(int i=1;i<bookDetails.length;i++){
            if(bookDetails[i][n-1].equals(str)){
                return i;
            }
        }
        return -1;
    }
    boolean search(){
        System.out.println("1.Search by book name\n2.Search by author name\n3.Search by ISBN code\nEnter your choice");
        int choice =sc.nextInt();
        switch(choice){
            case 1:
                System.out.println("Enter Book Name : ");
                break;
            case 2:
                System.out.println("Enter Author Name : ");
                break;
            case 3:
                System.out.println("Enter ISBN Code : ");
                break;
            default:
                System.out.println("Enter valid choice : ");
                search();
        }
        String str=s.nextLine();
        int row=traverse(choice,str);
        if(row!=-1){
            setData(bookDetails[row][0],bookDetails[row][1],bookDetails[row][2],bookDetails[row][3],bookDetails[row][4],Integer.parseInt(bookDetails[row][5]));
            show();
            return true;
        }
        else{
            return false;
        }
    }
    public void show(){
        System.out.println("Book Name : "+book_name+"\nAuthor Name : "+author_name+"\nPrice : "+"\nISBN Code : "+isbn+"\nCategory Name : "+category_name+"\nBook Count : "+book_count);
    }
}
