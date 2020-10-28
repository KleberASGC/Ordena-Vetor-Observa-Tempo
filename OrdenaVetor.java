import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OrdenaVetor {
    public static int[] sort(int[] vetor) {
        for (int i =  vetor.length/ 2 - 1; i >= 0; i--){
            heapify(vetor, vetor.length, i);
        }
       
        for (int i = vetor.length - 1; i>=0; i--)
        {
            
            int temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;
            
            heapify(vetor, i, 0);
        }
        return vetor;
    }
        static void heapify(int arr[], int arrayLength, int rootElementIndex)
    {
        
        int leftIndex = 2*rootElementIndex + 1;  
        int rightIndex = 2*rootElementIndex + 2;  
        
        int largest = rootElementIndex;
       
        if (leftIndex < arrayLength && arr[leftIndex] > arr[largest])
            largest = leftIndex;
        
        if (rightIndex < arrayLength && arr[rightIndex] > arr[largest])
            largest = rightIndex;
        
        if (largest != rootElementIndex){
           
            int swap = arr[rootElementIndex];
            arr[rootElementIndex] = arr[largest];
            arr[largest] = swap;
            
            heapify(arr, arrayLength, largest);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        try {
        File arquivos[];
        File diretorio = new File("C:/Users/klebi/Documents/Faculdade/2 Semestre/IAA/IAA-exercicio/version 1.0");
        arquivos = diretorio.listFiles();
        String Modelo = "I7-8550U_CPU:1.80GHZ_1.99GHZ_RAM:8.00GB";
        String Algoritmo = "HeapSort";
        String Linguagem = "Java_1.8.0";
        String Sistema = "Windows10";      
        String Ordenado = "Sim";
        String Largura = "64Bits";
        String Nome;
        int m=0;
        for(int i=0;i<arquivos.length;i++) {
        if(i<=249) System.out.print("100K_Array_" + (i+1) + " ");
        if(i>=250 && i<=499) System.out.print("10K_Array_" + (i-249) + " ");
        if(i>=500 && i<=749) System.out.print("1K_Array_" + (i-499) + " ");
        if(i>=750 && i<=999) System.out.print("1M_Array_" + (i-749) + " ");
        Scanner sc = new Scanner(arquivos[i]);
        int j=0;
        int k;
        int y=0;
        while (sc.hasNextInt()) {
           k = sc.nextInt();
           j++;
        }
        int[] vetor = new int[j];
        long tl = System.nanoTime();
        while(sc.hasNextInt()) {
            vetor[y] = sc.nextInt();
            y++;
        }
        long tlf = System.nanoTime() - tl;
        long start = System.nanoTime();
        sort(vetor);
        long elapsed = System.nanoTime() - start;
        System.out.printf("%d ", (j-1));
        System.out.printf("%d ", tlf);
        System.out.printf("%d ", elapsed);
        System.out.printf("%s ", Modelo);
        System.out.printf("%s ", Algoritmo);
        System.out.printf("%s ", Linguagem);
        System.out.printf("%s ", Sistema);
        System.out.printf("%s ", Largura);
        System.out.printf("%s ", Ordenado);
        m++;
        }
        } catch(Exception erro) {
            System.out.println("Erro");
        }
    
    }
}