package ApplicationDessin;

import java.awt.*;

public class ZoneDessin extends Canvas {
    private Planche planche = null;
    public ZoneDessin() {}
    public void paint(Graphics g){
        if(this.planche == null) return;
        g.setColor(this.planche.Couleur());
        Rectangle rect = new Rectangle(this.planche.PtFin().x - this.planche.Ptdepart().x,
                                       this.planche.PtFin().y - this.planche.Ptdepart().y
                );
        rect.setLocation(this.planche.Ptdepart());
        // Dessin d'un rectangle
        if(this.planche.Forme().equals("Rectangle")) {
            if(this.planche.Estremplie()) g.fillRect(rect.x, rect.y ,rect.width,rect.height);
            else  g.drawRect(rect.x, rect.y ,rect.width,rect.height);
        }
        // Dessin d'une elipse
        else {
            if(this.planche.Estremplie()) g.fillOval(rect.x, rect.y ,rect.width,rect.height);
            else  g.drawOval(rect.x, rect.y ,rect.width,rect.height);
        }

    }

    public void setPlanche(Planche planche){
        this.planche = planche;
    }
}
