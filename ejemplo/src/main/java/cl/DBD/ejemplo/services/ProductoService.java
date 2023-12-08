package cl.DBD.ejemplo.services;




import cl.DBD.ejemplo.models.Producto;
import cl.DBD.ejemplo.repositories.ProductoRepository;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@CrossOrigin
@RestController
public class ProductoService {
    private final ProductoRepository productoRepository;

    ProductoService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    @PostMapping("/producto")
    @ResponseBody
    public Producto crear(@RequestBody Producto producto){
        Producto resultado = productoRepository.crear(producto);
        return resultado;
    }
    


    // leer R
    @GetMapping("/producto")
    public List<Producto> getAllProductos(){
        return productoRepository.getAll();
    }
    //miercoles enero 2022
    @GetMapping("/producto/{id}")
    public List<Producto> getProducto(@PathVariable int id){
        return productoRepository.show(id);
    }

    @GetMapping("/producto/precioMaximo/{precio}")
    public List<Producto> getProductoLessThan(@PathVariable Integer precio){
        return productoRepository.showLessThan(precio);
    }

    @GetMapping("/producto/categoria/{categoria}")
    public List<Producto> getProductoByCategorie(@PathVariable int categoria){
        return productoRepository.showByCategorie(categoria);
    }
    

    // actualizar U
    @PutMapping("/producto/{id}")
    @ResponseBody
    public String updateProducto(@RequestBody Producto producto, @PathVariable int id){
        String retorno = productoRepository.update(producto,id);
        return retorno;
    }
    
    // borrar D
    @DeleteMapping("/producto/{id}")
    public void borrar(@PathVariable int id){
        productoRepository.delete(id);
    }
}
