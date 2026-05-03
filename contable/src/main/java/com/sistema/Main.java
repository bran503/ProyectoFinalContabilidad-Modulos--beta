package com.sistema;

import com.sistema.core.security.SessionManager;
import com.sistema.modulos.compras.Views.ProveedorView;
import com.sistema.modulos.compras.Views.FacturaCompraView;
import com.sistema.modulos.compras.Views.PagoView;

import javax.swing.*;
import java.awt.*;
//by dm
public class Main {
    public static void main(String[] args) {
        SessionManager.getInstancia().iniciarSesion(
                1L, // id_empresa
                "Empresa Demo S.A.", // nombre_empresa
                1L, // id_usuario
                "Admin" // nombre_usuario
        );

        JButton btnPagos = new JButton(" Cuentas por Pagar / Pagos");
        btnPagos.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnPagos.setFocusPainted(false);
        btnPagos.addActionListener(e -> {
            PagoView view = new PagoView();
            view.setVisible(true);
        });

        SwingUtilities.invokeLater(() -> {
            JFrame menu = new JFrame("MODULOS GT 1 ");
            menu.setSize(420, 320);
            menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            menu.setLocationRelativeTo(null);
            menu.setLayout(new GridLayout(0, 1, 15, 15));
            menu.getContentPane().setBackground(new Color(245, 245, 245));

            // 🔹 Botón Módulo Proveedores
            JButton btnProveedores = new JButton("Gestión de Proveedores");
            btnProveedores.setFont(new Font("Segoe UI", Font.BOLD, 15));
            btnProveedores.setFocusPainted(false);
            btnProveedores.addActionListener(e -> {
                ProveedorView view = new ProveedorView();
                view.setVisible(true);
            });

            JButton btnFacturas = new JButton(" Ingreso de Facturas (Compras)");
            btnFacturas.setFont(new Font("Segoe UI", Font.BOLD, 15));
            btnFacturas.setFocusPainted(false);
            btnFacturas.addActionListener(e -> {
                FacturaCompraView view = new FacturaCompraView();
                view.setVisible(true);
            });

            menu.add(btnProveedores);
            menu.add(btnFacturas);
            menu.add(btnPagos);

            // Mostrar menú
            menu.setVisible(true);
        });
    }
}