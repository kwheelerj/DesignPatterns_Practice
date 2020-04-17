package Structural.c_Composite.b_NeuralNetworks.wrong;

import java.util.ArrayList;

public class Neuron {
    public ArrayList<Neuron> in = new ArrayList<>(),
            out = new ArrayList<>();   // connections to other neurons: incoming / outgoing

    public void connectTo(Neuron other) { // unidirectional
        out.add(other);
        other.in.add(this);
    }
}

class NeuronLayer extends ArrayList<Neuron> {

}

class Demo {
    public static void main(String[] args) {
        Neuron neuron = new Neuron();
        Neuron neuron2 = new Neuron();
        NeuronLayer layer = new NeuronLayer();
        NeuronLayer layer2 = new NeuronLayer();

        neuron.connectTo(neuron2);
//        neuron.connectTo(layer);    // can't do
//        layer.connectTo(neuron);    // can't do
//        layer.connectTo(layer2);    // can't do

        /* Solution will not be to create 4 different connectTo methods for the 4 possible scenarios.
         *  Instead: use interfaces which is as general as possible for the purposes of establishing connections.
         */
    }
}