package zlx.service;

public interface UserService {
    public void add();
    public void delete();
    public void update();
    public void select();
}
 class UserServiceimp implements UserService{

    @Override
    public void add() {
        System.out.println("新增");
    }

    @Override
    public void delete() {
        System.out.println("删除");
    }

    @Override
    public void update() {
        System.out.println("更新");
    }

    @Override
    public void select() {
        System.out.println("选择");
    }
}