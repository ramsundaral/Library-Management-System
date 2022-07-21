package LibraryManagementSystem;

public class Process extends Main{
    String ISBN;
    int count;
    Book b;
    public void returnBook(Book b){
        System.out.println("Enter the isbn code of the book to return");
        this.ISBN = s.nextLine();
        this.b=b;
        int row=b.traverse(3,this.ISBN);
        if (row != -1) {
            b.setData(b.bookDetails[row][0], b.bookDetails[row][1], b.bookDetails[row][2], b.bookDetails[row][3], b.bookDetails[row][4], Integer.parseInt(b.bookDetails[row][5]));
            b.book_count+=1;
            rewriteData(b.book_name,"Book.txt",b.book_count+"",5,1);
            b.bookDetails[row][5]=""+b.book_count;
            System.out.println("Returned book :");
            System.out.println(b.book_name);;
        }
        else{
            System.out.println("Enter correct code");
            return;
        }
    }
    public int issueProcess(){
        if(this.count>0){
            b.book_count=b.book_count-1;
            rewriteData(b.book_name,"Book.txt",b.book_count+"",5,1);
            int row=b.traverse(3,this.ISBN);
            b.bookDetails[row][5]=""+b.book_count;
            return 0;
        }
        else{
            System.out.println("Return a book to issue this book");
            return -1;
        }
    }
    public int issue(String ISBN, int booksCount, Book b) {
        this.ISBN = ISBN;
        this.b = b;
        this.count=booksCount;
        System.out.println("Want to issue a book : ");
        if (s.nextLine().toLowerCase().equals("yes")) {
            if (ISBN.equals("no")) {
                System.out.println("Enter the book isbn code to issue : ");
                this.ISBN = s.nextLine();
                int row=b.traverse(3,this.ISBN);
                if (row != -1) {
                    b.setData(b.bookDetails[row][0], b.bookDetails[row][1], b.bookDetails[row][2], b.bookDetails[row][3], b.bookDetails[row][4], Integer.parseInt(b.bookDetails[row][5]));
                }
                else{
                    System.out.println("Enter correct code");
                    issue("no",this.count,this.b);
                }
            }
            if (b.book_count > 0) {
                return issueProcess();
            } else {
                System.out.println("Not Available");
                return -1;
            }
        }
        return -1;


    }


}