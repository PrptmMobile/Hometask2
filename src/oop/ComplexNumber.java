package oop;


public class ComplexNumber {
    public double Re;
    public double Im;

    public boolean isNil (){
        return (Re==0.0 && Im==0.0);
    }

    public ComplexNumber (double re, double im){
        Re = re; Im = im;
    }
    public ComplexNumber (int re, int im){
        Re = (double) re; Im = (double) im;
    }
    public ComplexNumber (double im){
        Re = 0.0; Im = im;
    }
    public ComplexNumber (int im){
        Re = 0.0; Im = (double) im;
    }

    public void print(){
        if (Re!=0.0 && Im != 0.0) System.out.print(Re+" "+Im+"i");
        else if (Re == 0.0 && Im != 0.0) System.out.print(Im+"i");
        else if (Re != 0.0 && Im == 0.0) System.out.print(Re);
        else System.out.println("0");
    }

    public ComplexNumber sum (ComplexNumber C1, ComplexNumber C2){
        double x = C1.Re + C2.Re;
        double y = C1.Im + C2.Im;
        return new ComplexNumber(x,y);
    }
    public ComplexNumber sub (ComplexNumber C1, ComplexNumber C2){
        if (C1.equals(C2)) return new ComplexNumber(0,0);
        double x = C1.Re - C2.Re;
        double y = C1.Im - C2.Im;
        return new ComplexNumber(x,y);
    }
    public ComplexNumber mul (ComplexNumber C1, ComplexNumber C2){
        if (C1.isNil() || C2.isNil()) return new ComplexNumber(0,0);
        double a = C1.Re * C2.Re;
        double b = C1.Re * C2.Im;
        double c = C1.Im * C2.Re;
        double d = C1.Im * C2.Im;
        return new ComplexNumber(a+d,b+c);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComplexNumber that = (ComplexNumber) o;

        if (Double.compare(that.Re, Re) != 0) return false;
        return Double.compare(that.Im, Im) == 0;

    }


}
