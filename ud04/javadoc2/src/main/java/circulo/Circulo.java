package circulo;
public class Circulo {
    private int x;
    private int y;
    private double radio;
    /**
     * Clase principal Circulo
     * @param valorX Valor en el eje X
     * @param valorY Valor en el eje Y
     * @param valorRadio Tamaño del radio
     * */
    public Circulo(int valorX, int valorY, double valorRadio) {
        establecerX(valorX);
        establecerY(valorY);
        establecerRadio(valorRadio);
    }

    /**
     * Metodo que establece un valor para el atributo valorX
     * @param valorX Valor a establecer en el atributo "valorX"
     * */
    public void establecerX(int valorX) {
        this.x = valorX;
    }

    /**
     * Metodo que devuelve el valor del atributo x
     * @return Int
     * */
    public int obtenerX() {
        return x;
    }

    /**
     *Metodo que establece un valor para el atributo y
     * @param valorY valor a establecer en y
     * */
    public void establecerY(int valorY) {
        y = valorY;
    }

    /**
     * Metodo que devuelve el valor del atributo y
     * @return Int
     * */
    public int obtenerY() {
        return y;
    }

    /**
     * Metodo que establece el valor del atributo valorRadio
     * @param valorRadio valor a establecer en el atributo valorRadio
     * Caso el valor a establecer sea menor que cero , se establece cero, caso contrario
     *  Se establece el valor introducido
     * */
    public void establecerRadio(double valorRadio) {

        radio = (valorRadio < 0.0 ? 0.0 : valorRadio);
    }

    /**
     * Metodo que devuelve el valor del atributo radio
     * @return double
     * */
    public double obtenerRadio() {
        return radio;
    }

    /**
     * Metodo que devuelve el valor del diametro, calculandolo con radio * 2
     * @return double
     * */
    public double obtenerDiametro() {
        return radio * 2;
    }

    /**
     * Metodo que devuelve el valor de la circunferencia en funcion del radio,
     * calculandolo con radio * 2 * PI
     * @return double
     * */
    public double obtenerCircunferencia() {
        return Math.PI * obtenerDiametro();
    }

    /**
     * Metodo que devuelve el valor del area de la circunferencia en funcion del radio,
     * calculandolo con radio * radio * PI
     * @return double
     * */
    public double obtenerArea() {
        return Math.PI * radio * radio;
    }

    /**
     * Metodo que sobreescribe el metodo toString de la clase circulo
     * @return String
     * */
    @Override
    public String toString() {
        return "Centro = [" + x + "," + y + "]; Radio = " + radio;
    }
}