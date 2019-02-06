import java.util.*;

public class SalesManage {

   static Products arr[][] = new Products[3][128];

   static void print() {
      System.out.println("더 이상 출력 안 됩니다.");
   }

   static void warPrint() {
      System.out.println("팔렸습니다.");
   }

   public static void main(String[] args) {
      int con;
      int id;
      int type;
      int price;
      int ISBN;
      int idNum;
      String exp = new String();
      String pro = new String();
      String writer = new String();
      String title = new String();
      String albumName = new String();
      String singerName = new String();
      String converInfor = new String();

      @SuppressWarnings("resource")
      Scanner sc = new Scanner(System.in);
      do {
         System.out.println("1.등록 2.상품 판매 3.재고조회 4.상품정보조회,5.상품삭제");
         int num = sc.nextInt();
         Label: if (num == 1) {
            System.out.println("1.책 2.회화책 3.앨범");
            type = sc.nextInt();
            switch (type) {
            case 1:
               if (Books.counBook == 128) {
                  print();
                  break Label;
               }
               System.out.println("정보를 입력해주세요!");
               System.out.println("id:");
               id = sc.nextInt();
               System.out.println("exp:");
               exp = sc.next();
               System.out.println("pro:");
               pro = sc.next();
               System.out.println("price:");
               price = sc.nextInt();
               System.out.println("ISBN:");
               ISBN = sc.nextInt();
               System.out.println("Writer:");
               writer = sc.next();
               System.out.println("title:");
               title = sc.next();
               arr[0][id] = new Books(id, exp, pro, price, ISBN, writer, title);
               break;
            case 2:
               if (CompactDisk.counDisk == 128) {
                  print();
                  break Label;
               }
               System.out.println("정보를 입력해주세요!");
               System.out.println("id:");
               id = sc.nextInt();
               System.out.println("exp:");
               exp = sc.next();
               System.out.println("pro:");
               pro = sc.next();
               System.out.println("price:");
               price = sc.nextInt();
               System.out.println(" albumName:");
               albumName = sc.next();
               System.out.println("singerName:");
               singerName = sc.next();
               arr[1][id] = new CompactDisk(id, exp, pro, price, albumName, singerName);
               break;
            case 3:
               if (ConversationBook.counCover == 128) {
                  print();
                  break Label;
               }
               System.out.println("정보를 입력해주세요!");
               System.out.println("id:");
               id = sc.nextInt();
               System.out.println("exp:");
               exp = sc.next();
               System.out.println("pro:");
               pro = sc.next();
               System.out.println("price:");
               price = sc.nextInt();
               System.out.println("ISBN:");
               ISBN = sc.nextInt();
               System.out.println("Writer:");
               writer = sc.next();
               System.out.println("title:");
               title = sc.next();
               System.out.println("converInfor:");
               converInfor = sc.next();
               arr[2][id] = new ConversationBook(id, exp, pro, price, ISBN, writer, title, converInfor);
               break;
            }
         } else if (num == 2) {
            System.out.println("판매한 상품의 type:1.책 2.회화책 3.앨범");
            type = sc.nextInt();
            System.out.println("상품의 id는?");
            idNum = sc.nextInt();
            switch (type) {
            case 1:
               Books.counBook--;
               warPrint();
               break;
            case 2:
               CompactDisk.counDisk--;
               warPrint();
               break;
            case 3:
               ConversationBook.counCover--;
               warPrint();
               break;
            }
         } else if (num == 3) {
            System.out.println("재고조회 할 상품의 type:1.책 2.회화책 3.앨범");
            type = sc.nextInt();
            switch (type) {
            case 1:
               Books books = new Books();
               Products prod = books;
               prod.extraPro();
               break;
            case 2:
               CompactDisk CDs = new CompactDisk();
               Products product = CDs;
               product.extraPro();
               break;
            case 3:
               ConversationBook CSbook = new ConversationBook ();
               Books bo = CSbook;
               bo.extraPro();
               break;

            }

         } else if (num == 4) {
            System.out.println("정보 출력할 상품의 type:1.책 2.회화책 3.앨범");
            type = sc.nextInt();
            switch (type) {
            case 1:
               System.out.println("상품의 id는?");
               idNum = sc.nextInt();
               Products product1 = arr[0][idNum];
               product1.PrintInf();
               break;
            case 2:
               System.out.println("상품의 id는?");
               idNum = sc.nextInt();
               Products product2 = arr[1][idNum];
               product2.PrintInf();
               break;
            case 3:
               System.out.println("상품의 id는?");
               idNum = sc.nextInt();
               Products product3 = arr[2][idNum];
               product3.PrintInf();
               break;
            }
         } else {
            System.out.println("삭제할 상품의 type:1.책 2.회화책 3.앨범");
            type = sc.nextInt();
            switch (type) {
            case 1:
               System.out.println("상품의 id는?");
               idNum = sc.nextInt();
               for (int i = idNum; i < Books.counBook - 1; i++)
                  arr[0][idNum] = arr[0][idNum + 1];
               arr[0][idNum].id--;
               Books.counBook--;
               break;
            case 2:
               System.out.println("상품의 id는?");
               idNum = sc.nextInt();
               for (int i = idNum; i < CompactDisk.counDisk - 1; i++)
                  arr[1][idNum] = arr[0][idNum + 1];
               arr[1][idNum].id--;
               CompactDisk.counDisk--;
               break;
            case 3:
               System.out.println("상품의 id는?");
               idNum = sc.nextInt();
               for (int i = idNum; i < ConversationBook.counCover - 1; i++)
                  arr[2][idNum] = arr[0][idNum + 1];
               arr[2][idNum].id--;
               ConversationBook.counCover--;
               break;
            default:
               System.out.println("잘못 선택하셨습니다.");
               break Label;
            }
         }

         System.out.println("계속하시겠습니까?Yes:1,No:-1");
         con = sc.nextInt();

      } while (con == 1);
   }

public class Products {
   int id;
   int price;
   String exp = new String();
   String pro = new String();
   public Products(){
      
   }
   public Products(int id, String exp, String pro, int price) {
      this.id = id;
      this.exp = exp;
      this.pro = pro;
      this.price = price;
   }

   public void PrintInf() {
      System.out.println("id:" + id);
      System.out.println("price:" + price);
      System.out.println("exp:" + exp);
      System.out.println("pro:" + pro);

   }
   public void extraPro(){
      
   }
}
class Books extends Products {
   static int counBook = 0;
   int ISBN;
   String writer = new String();
   String title = new String();
   public Books(){
      
   }
   public Books(int id, String exp, String pro, int price, int ISBN, String writer, String title) {
      super(id, exp, pro, price);
      this.ISBN = ISBN;
      this.writer = writer;
      this.title = title;
       counBook++;
   
   }
   

   public void PrintInf() {
      System.out.println("id:" + id);
      System.out.println("price:" + price);
      System.out.println("exp:" + exp);
      System.out.println("pro:" + pro);
      System.out.println("ISBN:" + ISBN);
      System.out.println("writer:" + writer);
      System.out.println("title:" + title);
   }
   public void extraPro(){
      System.out.println("책 현재 재고 "+counBook);
   }
}
public class CompactDisk extends Products{
   static int counDisk = 0;
   String albumName = new String();
   String singerName = new String();
   public CompactDisk(){
      
   }
   public CompactDisk(int id, String exp, String pro, int price, String albumName, String singerName) {
      super(id, exp, pro, price);
      this.albumName = albumName;
      this.singerName = singerName;
       counDisk++;
   }

   public void PrintInf() {
      System.out.println("id:" + id);
      System.out.println("price:" + price);
      System.out.println("exp:" + exp);
      System.out.println("pro:" + pro);
      System.out.println(" albumName : " + albumName);
      System.out.println(" singerName : " + singerName);
   }
   public void extraPro(){
      System.out.println("CD 현재 재고 "+counDisk );
   }

}
public class ConversationBook extends Books {
   static int counCover = 0;
   String converInfor = new String();

   public ConversationBook(){
      
   }
   public ConversationBook(int id, String exp, String pro, int price, int ISBN, String writer, String title, String converInfor) {
      super(id, exp, pro, price, ISBN, writer, title);
      this.converInfor = converInfor;
      counCover++;
   }

   public void PrintInf() {
      System.out.println("id:" + id);
      System.out.println("price:" + price);
      System.out.println("exp:" + exp);
      System.out.println("pro:" + pro);
      System.out.println("ISBN:" + ISBN);
      System.out.println("writer:" + writer);
      System.out.println("title:" + title);
      System.out.println("converInfor:" + converInfor);
   }
   public void extraPro(){
      System.out.println("회화책 현재 재고 "+counCover);
   }

}
