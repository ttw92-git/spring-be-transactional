package ttw.springbe.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ttw.springbe.transactional.services.TableAService;
import ttw.springbe.transactional.services.TableBService;

@RestController
@RequestMapping("/api")
public class TransactionalController {
    
    @Autowired
    private TableAService tableAService;
	@Autowired
	private TableBService tableBService;

	@GetMapping(value="/reset-to-default-and-get-data-a")
	public ResponseEntity<Object> resetToDefaultAndGetDataA() {
		return new ResponseEntity<>(tableAService.resetToNormalAndGetDataA(), HttpStatus.OK);
	}

	@GetMapping(value="/reset-to-default-and-get-data-b")
	public ResponseEntity<Object> resetToDefaultAndGetDataB() {
		return new ResponseEntity<>(tableBService.resetToNormalAndGetDataA(), HttpStatus.OK);
	}

	@GetMapping(value="/get-data-a")
	public ResponseEntity<Object> getAllDataA() {
		return new ResponseEntity<>(tableAService.getAll(), HttpStatus.OK);
	}

	@GetMapping(value="/get-data-b")
	public ResponseEntity<Object> getAllDataB() {
		return new ResponseEntity<>(tableBService.getAll(), HttpStatus.OK);
	}

    @GetMapping(value="/update-a-fail-transactional-fail")
	public ResponseEntity<Object> updateAFailTransactionalFail() {
		tableAService.updateFailTransactionalFail();
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@GetMapping(value="/update-a-fail-transactional-success")
	public ResponseEntity<Object> updateAFailTransactionalSuccess() {
		tableAService.updateFailTransactionalSuccess();
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@GetMapping(value="/update-a-and-b-fail-transactional-fail")
	public ResponseEntity<Object> updateAAndBFailTransactionalFail() {
		tableAService.updateAAndBFailTransactionalFail();
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@GetMapping(value="/update-a-and-b-fail-transactional-success")
	public ResponseEntity<Object> updateAAndBFailTransactionalSuccess() {
		tableAService.updateAAndBFailTransactionalSuccess();
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
