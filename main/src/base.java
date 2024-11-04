//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public class base {
//    private List<Cancion> canciones = new ArrayList<>();
//    private List<Album> albums = new ArrayList<>();
//    private List<Artista> artistas = new ArrayList<>();
//    private List<Genero> generos = new ArrayList<>();
//    private int nextCancionId = 1;
//    private int nextAlbumId = 1;
//    private int nextArtistaId = 1;
//    private int nextGeneroId = 1;
//
//
//
//
//    // Métodos para agregar, editar, eliminar y consultar
//
//    public void agregarCancion(String titulo, int duracion, int idAlbum, int idArtista, int idGenero) {
//        Cancion nuevaCancion = new Cancion(nextCancionId++, titulo, duracion, idAlbum, idArtista, idGenero);
//        canciones.add(nuevaCancion);
//    }
//
//    public void editarCancion(int id, String titulo, int duracion, int idAlbum, int idArtista, int idGenero) {
//        Optional<Cancion> cancionOpt = canciones.stream().filter(c -> c.getId() == id).findFirst();
//        cancionOpt.ifPresent(c -> {
//            c.setTitulo(titulo);
//            c.setDuracion(duracion);
//            c.setIdAlbum(idAlbum);
//            c.setIdArtista(idArtista);
//            c.setIdGenero(idGenero);
//        });
//    }
//
//    public void eliminarCancion(int id) {
//        canciones.removeIf(c -> c.getId() == id);
//    }
//
//    public List<Cancion> consultarCanciones(String titulo, String nombreAlbum, String nombreArtista, String nombreGenero, String nacionalidadArtista, Integer anioLanzamiento) {
//         return canciones.stream()
//                .filter(c -> titulo == null || c.getTitulo().equalsIgnoreCase(titulo))
//                .filter(c -> {
//                    if (nombreAlbum == null) return true;
//                    Optional<Album> albumOpt = albums.stream().filter(a -> a.getId() == c.getIdAlbum()).findFirst();
//                    return albumOpt.isPresent() && albumOpt.get().getTitulo().equalsIgnoreCase(nombreAlbum);
//                })
//                .filter(c -> {
//                    if (nombreArtista == null) return true;
//                    Optional<Artista> artistaOpt = artistas.stream().filter(a -> a.getId() == c.getIdArtista()).findFirst();
//                    return artistaOpt.isPresent() && artistaOpt.get().getNombre().equalsIgnoreCase(nombreArtista);
//                })
//                .filter(c -> {
//                    if (nombreGenero == null) return true;
//                    Optional<Genero> generoOpt = generos.stream().filter(g -> g.getId() == c.getIdGenero()).findFirst();
//                    return generoOpt.isPresent() && generoOpt.get().getNombreGenero().equalsIgnoreCase(nombreGenero);
//                })
//                .filter(c -> {
//                    if (nacionalidadArtista == null) return true;
//                    Optional<Artista> artistaOpt = artistas.stream().filter(a -> a.getId() == c.getIdArtista()).findFirst();
//                    return artistaOpt.isPresent() && artistaOpt.get().getNacionalidad().equalsIgnoreCase(nacionalidadArtista);
//                })
//                .filter(c -> {
//                    if (anioLanzamiento == null) return true;
//                    Optional<Album> albumOpt = albums.stream().filter(a -> a.getId() == c.getIdAlbum()).findFirst();
//                    return albumOpt.isPresent() && albumOpt.get().getAnioLanzamiento() == anioLanzamiento;
//                })
//                .collect(Collectors.toList());
//    }
//
//
//
//    public void agregarAlbum(String titulo, int anioLanzamiento, int idArtista, String generoPrincipal) {
//        Album nuevoAlbum = new Album(nextAlbumId++, titulo, anioLanzamiento, idArtista, generoPrincipal);
//        albums.add(nuevoAlbum);
//    }
//
//    public List<Album> consultarAlbums() {
//        return albums;
//    }
//
//    public void agregarArtista(String nombre, String fechaNacimiento, String nacionalidad, String generos) {
//        Artista nuevoArtista = new Artista(nextArtistaId++, nombre, fechaNacimiento, nacionalidad, generos);
//        artistas.add(nuevoArtista);
//    }
//
//    public List<Artista> consultarArtistas() {
//        return artistas;
//    }
//
//    public void agregarGenero(String nombreGenero, String descripcion) {
//        Genero nuevoGenero = new Genero(nextGeneroId++, nombreGenero, descripcion);
//        generos.add(nuevoGenero);
//    }
//
//    public List<Genero> consultarGeneros() {
//        return generos;
//    }
//}