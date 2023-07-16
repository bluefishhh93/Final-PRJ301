package admin;

import dal.ProductDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.ManageOrder;
//import jakarta.io.IOException;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Admin", value = "/admin")
public class Admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        return to AdminTemplate/index.html
        try {
            ProductDAO pd = new ProductDAO();
//            ArrayList<ManageOrder> list = pd.getOrderFromManager();
            request.setAttribute("countCustomer", pd.countCustomer());
//            request.setAttribute("list", list);
//            request.setAttribute("listOrder", list.size());
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}