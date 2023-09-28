/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Item;

/**
 *
 * @author ASUS
 */
public class AddNewStock extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            Item item = (Item) session.getAttribute("item");

            // รับข้อมูลครั้งแรกจาก addNewCar.html
            //
            if (item == null) {
                String name = request.getParameter("name");
                String type = request.getParameter("type");
                int price = Integer.parseInt(request.getParameter("price"));
                item = new Item();
                item.setName(name);
                item.setType(type);
                item.setPrice(price);

                session.setAttribute("item", item);
                out.println("<html><name>");
                out.println("<form action='addNewStock'>");
                out.println(item.getName() + " " + item.getType() + " " + item.getPrice() + "<br/>");
                out.println("<input type='submit' value='แก้ไข'>");
                out.println("</form></body></html>");
            } 
            // รับข้อมูลครั้งต่อมาจาก AddNewStock
            //
            else {
                // แสดงข้อมูล car เดิม
                out.println("<form action='addNewStock'>");
                out.println("ชื่อสินค้า : <input type='text' name='name' value='"
                        + item.getName()+ "'>");
                out.println("ประเภท : <input type='text' name='type' value='"
                        + item.getType() + "'>");
                out.println("ราคา : <input type='text' name='price' value='"
                        + item.getPrice() + "'>");
                out.println("<input type='submit' value='แก้ไข'>");
                out.println("</form></body></html>");
                
                // ลบตัวแปร sesion ออกไป เพื่อรับค่าข้อมูลที่ผู้ใช้แก้ไข มาสร้าง session ใหม่
                session.removeAttribute("item");
            }

        } catch (Exception e) {
            response.sendRedirect("error.html");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
