package list.perso.PopCulture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import list.perso.PopCulture.model.Mangas;
import list.perso.PopCulture.repo.MangasRepository;

@Service
public class MangasService {

    @Autowired
    private MangasRepository mangasRepository;

    public List<Mangas> getAll() {
        return mangasRepository.findAll();
    }

    public Mangas getById(Integer id) throws RuntimeException {

        if(id == null)
        {
            throw new RuntimeException("L'ID d'un mangas ne peut pas être null");
        }
        return mangasRepository.findById(id).orElse(null);
    }

    public Mangas createMangas(Mangas mangas) {
        return mangasRepository.save(mangas);
    }

    public Mangas updateMangas(Mangas mangas) {
        return mangasRepository.save(mangas);
    }


    public void deleteMangasById(Integer id) {
        mangasRepository.deleteById(id);
    }

    public void deleteMangas(Mangas mangas) {
        mangasRepository.delete(mangas);
    }
    
}
