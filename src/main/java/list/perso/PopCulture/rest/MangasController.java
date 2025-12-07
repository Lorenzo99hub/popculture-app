package list.perso.PopCulture.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import list.perso.PopCulture.model.Mangas;
import list.perso.PopCulture.service.MangasService;

@RestController
@RequestMapping("api/mangas")
public class MangasController {
    
    @Autowired
    private MangasService mangasService;

    @GetMapping
    public List<Mangas> allMangas() {
        return mangasService.getAll();  
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mangas> ficheMangas(@PathVariable Integer id) { /* ResponseEntity est un objet qui représente une réponse HTTP complète.
                                                                             On l'utilise quand on doit controler le code HTTP */
        Mangas mangas = mangasService.getById(id);

        if (mangas == null) {
            return ResponseEntity.notFound().build(); //Prépare une réponse HTTP 404, et build sert à terminer la creation de l'objet ResponseEntity, sinon on aurait 200 -> trompeur
        } else {
            return ResponseEntity.ok(mangas); // Prépare une réponse HTTP 200
        }
    }

    @PostMapping
    public Mangas ajouterMangas(@RequestBody Mangas mangas) {
        return mangasService.createMangas(mangas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mangas> modifierMangas(@PathVariable Integer id, @RequestBody Mangas mangasBody) {

    // Appelle le service pour mettre à jour
    Mangas updated = mangasService.updateMangas(id, mangasBody);

    if (updated == null) {
        return ResponseEntity.notFound().build(); // Manga non trouvé
    }

    return ResponseEntity.ok(updated); // Manga mis à jour
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerMangas(@PathVariable Integer id) {
        boolean deleted = mangasService.deleteMangasById(id);
        if(deleted == false) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}

// HTTP 200 signifie que la requête a fonctionné
// HTTP 404 Not Found signifie que ce qu'on recherche n'existe pas
// HTTP 500 signifie une erreur côté serveur. La requête du client est correcte, mais le serveur n'arrive pas à la traiter
        // -> Probleme de co a la base de données, erreur de conversion JSON, violation de contrainte dans la base