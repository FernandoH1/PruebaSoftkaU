package prueba.presentacion;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import prueba.logica.Fabrica;
import prueba.logica.entidades.Categoria;
import prueba.logica.entidades.Pregunta;

public class Partida extends javax.swing.JFrame implements Runnable {

    private Thread hilo;
    private int multiplicador;
    private Pregunta preguntaActual;
    private int puntaje;
    private MenuPrincipal menuPrincipal;
    private Fabrica fabrica;
    private List<Categoria> categorias;
    Long nivel;

    public Partida(MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
        initComponents();
        multiplicador = 10;
        this.outputTempo.setText(multiplicador + "");
        hilo = new Thread(this);
        hilo.start();
        fabrica = new Fabrica();
        nivel = Long.parseLong("1");
        cargarCategoria();
        mostrarPregunta();

    }

    public void cargarCategoria() {
        categorias = fabrica.getCategoriaControlador().getCategoriaPorRonda(nivel);
        System.out.println(categorias);
    }

    public void mostrarPregunta() {
        preguntaActual = getRandomCategoria().getRandomPregunta();
        this.outputPregunta.setText(preguntaActual.getNombre());
        //System.out.println(pregunta.getNombre());
        mostrarOpciones(preguntaActual);
    }

    public void mostrarOpciones(Pregunta pregunta) {
        btn1.setText(pregunta.getOpciones().get(0).getNombre());
        btn2.setText(pregunta.getOpciones().get(1).getNombre());
        btn3.setText(pregunta.getOpciones().get(2).getNombre());
        btn4.setText(pregunta.getOpciones().get(3).getNombre());
    }

    public void verificarRespuesta(String opcion) {
        if (preguntaActual.esCorrecta(opcion)) {
            if (nivel < 5) {
                nivel++;
                puntaje+=10*multiplicador;
                hilo.stop();
                multiplicador = 10;
                this.outputTempo.setText(multiplicador + "");
                hilo = new Thread(this);
                hilo.start();
                this.outputScore.setText("Puntaje: " + puntaje);
                this.outputRonda.setText(nivel + "");
                cargarCategoria();
                mostrarPregunta();
            } else {
                hilo.stop();
                JOptionPane.showMessageDialog(null, "Partida Ganada!! Puntaje Final: "+puntaje);
                menuPrincipal.finPartida();
            }
        } else {
            JOptionPane.showMessageDialog(null, "GAME OVER!! Respuesta Incorrecta!!");
            menuPrincipal.finPartida();
        }
    }

    public Categoria getRandomCategoria() {
        int posicion = (int) (Math.random() * 4);
        System.out.println(posicion);
        return categorias.get(posicion);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Group1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        outputPregunta = new javax.swing.JLabel();
        outputRonda = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        outputScore = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        outputTempo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setPreferredSize(new java.awt.Dimension(1184, 728));

        jLabel1.setFont(new java.awt.Font("Dosis ExtraBold", 2, 72)); // NOI18N
        jLabel1.setText("Ronda N°");

        outputPregunta.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        outputPregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        outputPregunta.setText("¿PREGUNTA?");

        outputRonda.setFont(new java.awt.Font("Dosis ExtraBold", 2, 72)); // NOI18N
        outputRonda.setText("1");

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn1.setText("Opcion1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn2.setText("Opcion2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn3.setText("Opcion3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn4.setText("Opcion4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        outputScore.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        outputScore.setText("Score = 0");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setText("Multiplicador");

        outputTempo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        outputTempo.setText("2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(outputPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(outputScore)
                .addGap(278, 278, 278)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputRonda, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputTempo)
                .addGap(106, 106, 106))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn4, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                            .addComponent(btn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(outputScore)
                                .addGap(94, 94, 94)
                                .addComponent(outputPregunta))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(outputTempo)
                                    .addComponent(jLabel1)
                                    .addComponent(outputRonda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(140, 140, 140)))
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LoginUsuario loginUsuario = new LoginUsuario();
        loginUsuario.show();
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        verificarRespuesta(btn1.getText());
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        verificarRespuesta(btn2.getText());
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        verificarRespuesta(btn3.getText());
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        verificarRespuesta(btn4.getText());
    }//GEN-LAST:event_btn4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Group1;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel outputPregunta;
    private javax.swing.JLabel outputRonda;
    private javax.swing.JLabel outputScore;
    private javax.swing.JLabel outputTempo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while (multiplicador > 1) {
            multiplicador--;
            //System.out.println(multiplicador);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Partida.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.outputTempo.setText(multiplicador + "");
        }
    }
}
