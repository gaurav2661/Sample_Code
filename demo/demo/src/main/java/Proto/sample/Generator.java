package Proto.sample;

import com.google.protobuf.Timestamp;
import src.main.proto.*;

import java.util.Random;

public class Generator {
    private Random random;

    public KeyboardMessage.Keyboard keyboard(){
        return KeyboardMessage.Keyboard.newBuilder().setLayout(randomKeyboardLayout()).setBacklit(random.nextBoolean()).build();
    }

    private KeyboardMessage.Keyboard.Layout randomKeyboardLayout() {
        switch (random.nextInt(3)){
            case 1:
                return KeyboardMessage.Keyboard.Layout.QWERTY;
            case 2:
                return KeyboardMessage.Keyboard.Layout.QWERTZ;
            default:
                return KeyboardMessage.Keyboard.Layout.AZERTY;
        }
    }
    public ProcessorMessage.CPU newCpu(){
        String brand=randomCpuBrand();
        String name = randomCpuName(brand);
        int numberCores=randomInt(2,8);
        int numberThreads= randomInt(numberCores,12);

        double minGhz=randomDouble(2.0,3.5);
        double maxghz=randomDouble(minGhz,5.0);
        return ProcessorMessage.CPU.newBuilder().setBrand(brand).setName(name)
                .setNumberCores(numberCores).setNumberThreads(numberThreads)
                .setMinGhz(minGhz).setMaxGhz(maxghz).build();

    }
    public ProcessorMessage.GPU gpu(){
        String brand=randomGpuBrand();
        String name = randomGpuName(brand);

        double minGhz = randomDouble(1.0,1.5);
        double maxGhz = randomDouble(minGhz,2.0);

        MemoryMessage.Memory memory = MemoryMessage.Memory.newBuilder().setValue(randomInt(2,6)).setUnit(MemoryMessage.Memory.Unit.GIGABYTE).build();
        return  ProcessorMessage.GPU.newBuilder().setBrand(brand).setName(name).setMinGhz(minGhz).setMaxGhz(maxGhz).setMemory(memory).build();

    }
    public MemoryMessage.Memory newRam(){
        return MemoryMessage.Memory.newBuilder().setValue(randomInt(4,64)).setUnit(MemoryMessage.Memory.Unit.GIGABYTE).build();
    }
    public StorageMessage.Storage NewSSD(){
        MemoryMessage.Memory memory = MemoryMessage.Memory.newBuilder().setValue(randomInt(128,1024))
                .setUnit(MemoryMessage.Memory.Unit.TERABYTE).build();
        return StorageMessage.Storage.newBuilder().setMemory(memory).setDriver(StorageMessage.Storage.Driver.HDD).build();
    }
    public StorageMessage.Storage NewHDD(){
        MemoryMessage.Memory memory = MemoryMessage.Memory.newBuilder().setValue(randomInt(1,6))
                .setUnit(MemoryMessage.Memory.Unit.GIGABYTE).build();
        return StorageMessage.Storage.newBuilder().setMemory(memory).setDriver(StorageMessage.Storage.Driver.SDD).build();
    }
    public ScreenMessage.Screen newScreen(){
        int height = randomInt(1080,4320);
        int width = height * 16/9;
        ScreenMessage.Screen.Resolution resolution= ScreenMessage.Screen.Resolution.newBuilder()
                .setHeight(height).setWidth(width).build();
        return ScreenMessage.Screen.newBuilder().setResolution(resolution)
                .setMultitouch(random.nextBoolean()).setSize(randomFloat(13,17))
                .setPanel(randomScreenPanel()).build();
    }
    public LaptopMessage.Laptop newLaptop(){
        random = new Random();
        String brand = randomStringFromSet("Apple","Hp","Lenovo");
        String name = randomLaptopName(brand);
        double weightKg =randomDouble(1.0,3.0);
        double priceUSD = randomDouble(1500,3000);
        int releaseYear = randomInt(2015,2021);

        return LaptopMessage.Laptop.newBuilder().setBrand(brand).setName(name)
                .setPriceUsd(priceUSD)
                .setReleaseYear(releaseYear)
                .setCpu(newCpu())
                .addStorage(NewHDD())
                .addStorage(NewSSD())
                .setRam(newRam())
                .setScreen(newScreen())
                .setKeyboard(keyboard())
                .setKg(weightKg)
                .setUpdatedAt(Timestamp.newBuilder().build()).build();
    }

    private String randomLaptopName(String brand) {
        switch (brand){
            case "Apple":
                return randomStringFromSet("Mackbook air","Mackbook pro");
            case "Hp":
                return randomStringFromSet("Elitebook 870","Elitebook 850","Elitebook 820");
            default:
                return randomStringFromSet("Ideapad 570","Ideapad 670","Ideapad 770");
        }
    }

    private ScreenMessage.Screen.Panel randomScreenPanel() {
        if(random.nextBoolean()){
            return ScreenMessage.Screen.Panel.IPS;
        }
        return ScreenMessage.Screen.Panel.OLED;
    }


    private float randomFloat(int min, int max) {
        return min+random.nextFloat()*(max-min);
    }


    private String randomGpuName(String brand) {
        if(brand=="NVIDIA"){
            return randomStringFromSet("Nvidia GTX 1080 ",
                    "Nvidia RTX 2080",
                    "Nvidia RTX 3060",
                    "Nvidia Quadro RTX A4000");
        }return randomStringFromSet("Nvidia RTX 3070",
                "Nvidia RTX 3060 ",
                "Nvidia Titan Pascal",
                "Nvidia RTX 2080 SUPER");
    }

    private String randomGpuBrand() {
        return randomStringFromSet("NVIDIA","AMD");

    }

    private double randomDouble(double min, double max) {
        return min+random.nextDouble()*(max-min);
    }

    private int randomInt(int min, int max) {
        return min+random.nextInt((max-min)+1);
    }

    private String randomCpuName(String brand) {
        if(brand=="intel"){
            return randomStringFromSet("Intel Atom® Processor S1200 Product Family","Intel Pentium (Nehalem)" ,
                    "Core i3 (1st Generation)" ,
                    "Core i5 (1st Generation)",
                    "Core i7 (1st Generation)");
        }
        return randomStringFromSet("Am2909 4-bit-slice address sequencer",
                "Am2910 12-bit address sequencer",
                "Am2911 4-bit-slice address sequencer",
                "Am2912 Bus Transceiver",
                "Am2913 Priority Interrupt Expander",
                "Am2914 Priority Interrupt Controller");
    }

    private String randomCpuBrand() {
        return randomStringFromSet("intel","AMD");
    }

    private String randomStringFromSet(String ... a) {
        int n=a.length;
        if(n==0){
            return "";
        }
        return a[random.nextInt(n)];
    }
    public static void main(String args[]){
        Generator generator = new Generator();
        LaptopMessage.Laptop laptop = generator.newLaptop();
        System.out.println(laptop);
    }

}
