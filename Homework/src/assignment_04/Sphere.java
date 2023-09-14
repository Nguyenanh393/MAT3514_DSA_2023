package assignment_04;

public class Sphere {
    //create
    public Double r;
    public Double x;
    public Double y;
    public Double z;

    public Sphere(Double x, Double y, Double z, Double r) {
        this.r = r;
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Sphere() {
    }

    // calculate surrounding area
    Double SurroundArea() {
        return 4 * Math.PI * Math.pow(r, 2);
    }

    // calculate volume
    Double Volume() {
        return 4 / 3 * Math.PI * Math.pow(r, 3);
    }

    //Determine whether two spheres are enclosed or intersect
    public String DetermineStatus(Sphere other) {
        Double distanceCenter = Math.sqrt((this.x - other.x) * (this.x - other.x) + 
                                            (this.y - other.y) * (this.y - other.y) + 
                                            (this.z - other.z) * (this.z - other.z));

        if (distanceCenter == Math.abs(this.r - other.r) || distanceCenter == this.r + other.r)
            return "touch" ;
        if (distanceCenter > Math.abs(this.r - other.r) && distanceCenter < this.r + other.r)
            return "intersect";
        if (distanceCenter < Math.abs(this.r - other.r))
            return "enclosed";
        return "neither intersect nor encolsed";
    }

    public String toString() {
        return String.format("(x - %d)^2 + (y - %d)^2 + (z - %d)^2 = %d^2",this.x, this.y, this.z, this.r);
    }
}

