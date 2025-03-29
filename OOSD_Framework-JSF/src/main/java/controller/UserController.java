package controller;

import dao.UserDAO;
import model.User;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.io.Serializable;

@Named("userSearchController") // -> Tên bean bạn dùng trong xhtml
@RequestScoped
public class UserController implements Serializable {
    private String username;
    private String message;

    public void search() {
        UserDAO dao = new UserDAO();
        User user = dao.findUserByUsername(username); // dùng DAO đã sửa bảng users
        if (user == null) {
            message = "❌ Không tìm thấy người dùng: " + username;
        } else {
            int count = dao.countPostsByUserId(user.getId());
            message = "✅ Người dùng " + user.getUsername() + " có " + count + " bài viết.";
        }
    }

    // Getters & Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }
}
