import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Cancion {  //Cancion
    private int id;
    private String titulo;
    private int duracion; // en segundos
    private int idAlbum;
    private int idArtista;
    private int idGenero;

    public Cancion(int id, String titulo, int duracion, int idAlbum, int idArtista, int idGenero) {
        this.id = id;
        this.titulo = titulo;
        this.duracion = duracion;
        this.idAlbum = idAlbum;
        this.idArtista = idArtista;
        this.idGenero = idGenero;
    }

    // Getters y Setters
    
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public int getDuracion() { return duracion; }
    public void setDuracion(int duracion) { this.duracion = duracion; }
    public int getIdAlbum() { return idAlbum; }
    public void setIdAlbum(int idAlbum) { this.idAlbum = idAlbum; }
    public int getIdArtista() { return idArtista; }
    public void setIdArtista(int idArtista) { this.idArtista = idArtista; }
    public int getIdGenero() { return idGenero; }
    public void setIdGenero(int idGenero) { this.idGenero = idGenero; }

    @Override
    public String toString() {
        return "Cancion{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                ", idAlbum=" + idAlbum +
                ", idArtista=" + idArtista +
                ", idGenero=" + idGenero +
                '}';
    }
}

class Album {
    private int id;
    private String titulo;
    private int anioLanzamiento;
    private int idArtista;
    private String generoPrincipal;

    public Album(int id, String titulo, int anioLanzamiento, int idArtista, String generoPrincipal) {
        this.id = id;
        this.titulo = titulo;
        this.anioLanzamiento = anioLanzamiento;
        this.idArtista = idArtista;
        this.generoPrincipal = generoPrincipal;
    }

    // Getters y Setters

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", anioLanzamiento=" + anioLanzamiento +
                ", idArtista=" + idArtista +
                ", generoPrincipal='" + generoPrincipal + '\'' +
                '}';
    }
}

class Artista {
    private int id;
    private String nombre;
    private String fechaNacimiento;
    private String nacionalidad;
    private String generos; // Puede ser una lista separada por comas

    public Artista(int id, String nombre, String fechaNacimiento, String nacionalidad, String generos) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.generos = generos;
    }

    // Getters y Setters

    @Override
    public String toString() {
        return "Artista{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", generos='" + generos + '\'' +
                '}';
    }
}

class Genero {
    private int id;
    private String nombreGenero;
    private String descripcion;

    public Genero(int id, String nombreGenero, String descripcion) {
        this.id = id;
        this.nombreGenero = nombreGenero;
        this.descripcion = descripcion;
    }

    // Getters y Setters

    @Override
    public String toString() {
        return "Genero{" +
                "id=" + id +
                ", nombreGenero='" + nombreGenero + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}


public class Basededatos {
    private List<Cancion> canciones;
    private List<Album> albums;
    private List<Artista> artistas;
    private List<Genero> generos;
    private int nextCancionId = 1;
    private int nextAlbumId = 1;
    private int nextArtistaId = 1;
    private int nextGeneroId = 1;

    public Basededatos() {
        canciones = new ArrayList<>();
        albums = new ArrayList<>();
        artistas = new ArrayList<>();
        generos = new ArrayList<>();
    }

    // Métodos para agregar, editar, eliminar y consultar

    public void agregarCancion(String titulo, int duracion, int idAlbum, int idArtista, int idGenero) {
        Cancion nuevaCancion = new Cancion(nextCancionId++, titulo, duracion, idAlbum, idArtista, idGenero);
        canciones.add(nuevaCancion);
    }

    public void editarCancion(int id, String titulo, int duracion, int idAlbum, int idArtista, int idGenero) {
        Optional<Cancion> cancionOpt = canciones.stream().filter(c -> c.getId() == id).findFirst();
        cancionOpt.ifPresent(c -> {
            c.setTitulo(titulo);
            c.setDuracion(duracion);
            c.setIdAlbum(idAlbum);
            c.setIdArtista(idArtista);
            c.setIdGenero(idGenero);
        });
    }

    public void eliminarCancion(int id) {
        canciones.removeIf(c -> c.getId() == id);
    }

    public List<Cancion> consultarCanciones() {
        return canciones;
    }

    public void agregarAlbum(String titulo, int anioLanzamiento, int idArtista, String generoPrincipal) {
        Album nuevoAlbum = new Album(nextAlbumId++, titulo, anioLanzamiento, idArtista, generoPrincipal);
        albums.add(nuevoAlbum);
    }

    public List<Album> consultarAlbums() {
        return albums;
    }

    public void agregarArtista(String nombre, String fechaNacimiento, String nacionalidad, String generos) {
        Artista nuevoArtista = new Artista(nextArtistaId++, nombre, fechaNacimiento, nacionalidad, generos);
        artistas.add(nuevoArtista);
    }

    public List<Artista> consultarArtistas() {
        return artistas;
    }

    public void agregarGenero(String nombreGenero, String descripcion) {
        Genero nuevoGenero = new Genero(nextGeneroId++, nombreGenero, descripcion);
        generos.add(nuevoGenero);
    }

    public List<Genero> consultarGeneros() {
        return generos;
    }
}