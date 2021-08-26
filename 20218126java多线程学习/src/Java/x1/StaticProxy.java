package Java.x1;
interface Marry{
 void HappyMarry();

}
class You implements Marry{


 @Override
 public void HappyMarry() {
  System.out.println("Getting Marry");
 }
}
class WeddingCompany implements Marry{
 private Marry target;
 public WeddingCompany(Marry Target){
  this.target=Target;
 }

 @Override
 public void HappyMarry() {
  before();
  this.target.HappyMarry();
  after();

 }
 private void before(){
  System.out.println("布置现场");
 }
 private void after(){
  System.out.println("收尾款");
 }
}
public class StaticProxy {
 public static void main(String[] args) {
  WeddingCompany wc1=new WeddingCompany(new You());
  wc1.HappyMarry();
 }
}
