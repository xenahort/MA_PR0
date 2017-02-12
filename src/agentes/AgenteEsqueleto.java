/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import GUI.AgenteDemoJFrame;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Esqueleto de agente para la estructura general que deben tener todos los
 * agentes
 */
public class AgenteEsqueleto extends Agent {

    //Variables del agente
    private AgenteDemoJFrame myGui;
    int ejecuciones, ejecuciones2;
    TareaEjercicio tareaE;

    @Override
    protected void setup() {

        //Inicialización de las variables del agente
        ejecuciones2 = ejecuciones = 0;

        //Configuración del GUI
        myGui = new AgenteDemoJFrame(this);
        myGui.setVisible(true);

        //Registro del agente en las Páginas Amarrillas
        myGui.presentarSalida("Agente registrado en las paginas amarillas\n");
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("Tipo de Servicio");
        sd.setName("Nombre del Servicio");
        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }

        //Registro de la Ontología
        System.out.println("Se inicia la ejecución del agente: " + this.getName());

        //Añadir las tareas principales
        addBehaviour(new TareaEjemplo(this, 10000));
        tareaE=new TareaEjercicio(this, 10000);
        addBehaviour(tareaE);
        myGui.habilitarCerrado(false);
    }

    @Override
    protected void takeDown() {
        //Desregristo del agente de las Páginas Amarillas
        try {
            DFService.deregister(this);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }

        //Liberación de recursos, incluido el GUI
        myGui.dispose();

        //Despedida
        System.out.println("Finaliza la ejecución del agente: " + this.getName());
    }

    //Métodos de trabajo del agente
    //Clases internas que representan las tareas del agente
    public class TareaEjemplo extends TickerBehaviour {

        //Tarea de ejemplo que se repite cada 10 segundos
        public TareaEjemplo(Agent a, long period) {
            super(a, period);
            myGui.presentarSalida("\nComienza la tarea TareaEjemplo");
        }

        @Override
        protected void onTick() {
            ++ejecuciones;
            myGui.presentarSalida("\nEjecución número: " + ejecuciones + " de TareaEjemplo");
            if (ejecuciones == 4) {
                myGui.habilitarCerrado(true);
                myGui.presentarSalida("\nYa se puede cerrar la interfaz.");
            }
        }
    }

    public class TareaEjercicio extends TickerBehaviour {

        //Tarea de ejemplo que se repite cada 10 segundos
        public TareaEjercicio(Agent a, long period) {
            super(a, period);
            myGui.presentarSalida("\nComienza la tarea TareaEjercicio");
        }

        @Override
        protected void onTick() {
            ++ejecuciones2;
            myGui.presentarSalida("\nEjecución número: " + ejecuciones2 + " de TareaEjercicio: ");
            if(ejecuciones%2==0){
                secuenciaPar();
            }else{
                secuenciaImpar();
            }
            if(ejecuciones2==10){
                myGui.presentarSalida("\nAcaba la tarea: TareaEjercicio");
                removeBehaviour(tareaE);
            }
        }
        
        public void secuenciaPar(){
        
        }

        public void secuenciaImpar(){
        
        }
    }
}
