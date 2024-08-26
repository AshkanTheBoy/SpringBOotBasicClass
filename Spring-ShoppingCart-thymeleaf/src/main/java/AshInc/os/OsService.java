package AshInc.os;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
    public class OsService {
        @Autowired
        private OsRepository osRepository;

        public List<Os> findAll() {
            return osRepository.findAll();
        }

        public Os save(Os os) {
           return osRepository.save(os);
        }

        public Os findById(Long id) {
            return osRepository.findById(id).get();
        }

        public void deleteById(Long id) {
            osRepository.deleteById(id);
        }
    } 