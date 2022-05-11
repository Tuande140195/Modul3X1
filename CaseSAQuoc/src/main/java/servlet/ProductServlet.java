package servlet;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String action = request.getParameter("action");
       if (action== null){
           action = "list";
       }
       switch (action){
           case "create":
               showCreate(request,response);
               break;
           case "update":
               showUpdate(request, response);
               break;
           case "view":
               break;
           case "delete":
               delete(request, response);
               break;
           case "list":
           default:
               showList(request,response);
       }


    }
    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.findAll();
        HttpSession session = request.getSession();
        String message = (String)session.getAttribute("message");
        request.setAttribute("message", message);
        request.setAttribute("list", productList);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
    private void showCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("create.jsp").forward(request,response);
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String id =  request.getParameter("id");

        productService.remove(id);
        response.sendRedirect(request.getContextPath()+ "/product?action=list");
    }
    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id =  request.getParameter("id");
        Product p= productService.findById(id);
        request.setAttribute("product",p);
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String action = request.getParameter("action");
    if (action== null){
            action = "list";
        }
        switch (action){
            case "create":
                create(request,response);
                break;
            case "update":
                update(request, response);
        }
    }
    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     productService.create(getProductFromView(request));
        //    String id = request.getParameter("id");
//    String name = request.getParameter("name");
//    Double price = Double.parseDouble(request.getParameter("price"));
//    int quantity = Integer.parseInt(request.getParameter("quantity"));
//    String color = request.getParameter("color");
//    String describe = request.getParameter("describe");
//    String menu = request.getParameter("menu");
//
//    ProductService productService = new ProductServiceImpl();
//    productService.create(new Product(id, name, price, quantity, color, describe, menu));
    response.sendRedirect(request.getContextPath()+ "/product?action=list");

    }
    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ipm =productService.update(getProductFromView(request));
        String message = ipm>0 ? "update successfully" : "Update fail" ;
        HttpSession session = request.getSession();
        session.setAttribute("message", message);
//        String id = request.getParameter("id");
//        String name = request.getParameter("name");
//        Double price = Double.parseDouble(request.getParameter("price"));
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
//        String color = request.getParameter("color");
//        String describe = request.getParameter("describe");
//        String menu = request.getParameter("menu");
//
//        ProductService productService = new ProductServiceImpl();
//        productService.update( new Product(id,name,price,quantity,color,describe,menu));
        response.sendRedirect(request.getContextPath()+ "/product?action=list");

    }



    private Product getProductFromView(HttpServletRequest request) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String describe = request.getParameter("describe");
        String menu = request.getParameter("menu");

       return  new Product(id, name, price, quantity, color, describe, menu);
    }
    }
