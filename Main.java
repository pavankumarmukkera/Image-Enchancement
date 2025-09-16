import org.deeplearning4j.datasets.iterator.impl.MnistDataSetIterator;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.ConvolutionMode;
import org.deeplearning4j.nn.conf.GradientNormalization;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.Updater;
import org.deeplearning4j.nn.conf.layers.ConvolutionLayer;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.learning.config.Adam;
import org.nd4j.linalg.lossfunctions.LossFunctions;

public class CNNExample {

    public static void main(String[] args) throws Exception {
        // Set hyperparameters
        int batchSize = 64;
        int nEpochs = 1;
        int seed = 123;

        // Load MNIST dataset
        DataSetIterator mnistTrain = new MnistDataSetIterator(batchSize, true, seed);
        DataSetIterator mnistTest = new MnistDataSetIterator(batchSize, false, seed);

        // Define CNN architecture
        MultiLayerConfiguration config = new NeuralNetConfiguration.Builder()
            .seed(seed)
            .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
            .updater(new Adam(1e-3))
            .list()
            .layer(new ConvolutionLayer.Builder(5, 5)
                .nIn(1)
                .stride(1, 1)
                .nOut(20)
                .activation(Activation.RELU)
                .build())
            .layer(new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
                .nOut(10)
                .activation(Activation.SOFTMAX)
                .build())
            .setInputType(org.deeplearning4j.nn.conf.inputs.InputType.convolutionalFlat(28, 28, 1))
            .build();

        // Create model
        MultiLayerNetwork model = new MultiLayerNetwork(config);
        model.init();

        // Print the score (loss function value) once every iteration
        model.setListeners(new ScoreIterationListener(1));

        // Train the model
        for (int i = 0; i < nEpochs; i++) {
            model.fit(mnistTrain);
            System.out.println("Completed epoch " + (i + 1) + " of " + nEpochs);
        }

        // Evaluate the model on the test set
        Evaluation eval = model.evaluate(mnistTest);
        System.out.println(eval.stats());
    }
}
