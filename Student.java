package LibraryManagementSystem;

import java.io.*;

public class Student extends Main {
    int booksCount;
    public String Name;
        public void writeData(Book b){
            rewriteData(this.Name,"StudentData.txt",this.booksCount+"",3,1);
            try{
                FileWriter fw = new FileWriter(Name+".txt",true);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(b.book_name+","+b.isbn);
                pw.close();
                readData();
                System.out.println("---Book Issued---");
            }
            catch(IOException e){
                System.out.println("error");
            }

            return;
        }
        public void readData(){
            try {
                String s;
                FileReader fr = new FileReader(Name + ".txt");
                BufferedReader br = new BufferedReader(fr);
                System.out.print("\n");
                while ((s = br.readLine()) != null) {
                   String[] str=s.split(",");
                    for(int i=0;i<str.length;i++){
                        System.out.print(str[i]+" ");
                    }
                    System.out.print("\n");
                }
                System.out.print("\n");
            }
            catch (Exception e){
                System.out.println("No books issued");
            }
            return;
        }
    public void user(String Name,int booksCount){
        this.Name=Name;
        this.booksCount=booksCount;
        System.out.println("1.DISPLAY OF CATEGORIES\n2.SEARCH FOR A BOOK\n3.RETURN A BOOK\n4.ISSUED BOOKS\n5.EXIT\nEnter Your Choice : ");
        int choice1=sc.nextInt();
        Management m=new Management();
        Book a= new Book();
        Process p=new Process();
        switch(choice1) {
            case 1:
                m.show();
                if(p.issue("no", this.booksCount, a)==0){
                    this.booksCount = booksCount - 1;
                    writeData(a);
                }
                break;
            case 2:
                if (a.search() == true) {
                    if(p.issue(a.isbn, booksCount, a)==0){
                        this.booksCount = booksCount - 1;
                       writeData(a);
                    }
                } else {
                    System.out.println("---Not Found---");
                }
                break;
            case 3:
                readData();
                p.returnBook(a);
                rewriteData(a.isbn,this.Name+".txt",null,1,2);
                this.booksCount = booksCount + 1;
                rewriteData(this.Name,"StudentData.txt",this.booksCount+"",3,1);
                break;
            case 4:
                readData();
                break;
            case 5:
                return;
            default:
                System.out.println("Enter valid choice");
                user(Name, booksCount);
        }
        user(this.Name, this.booksCount);
        return;

    }
    }
