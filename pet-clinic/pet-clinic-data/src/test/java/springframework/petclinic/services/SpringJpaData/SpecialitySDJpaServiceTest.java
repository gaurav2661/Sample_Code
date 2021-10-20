package springframework.petclinic.services.SpringJpaData;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import springframework.petclinic.Model.Speciality;
import springframework.petclinic.repositories.SpecialityRepository;
import springframework.petclinic.services.SpecialitiesService;

import javax.management.RuntimeMBeanException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {

    @Mock(lenient = true)
    SpecialityRepository specialityRepository;
    @InjectMocks
    SpecialitySDJpaService specialitySDJpaService;

    @Test
    void save() {
        Speciality speciality = new Speciality();
        speciality.setId(1L);

        when(specialityRepository.save(any(Speciality.class))).thenReturn(speciality);

        Speciality speciality1 = specialitySDJpaService.save(speciality);

        assertNotNull(speciality1);
    }
    @Test
    void doThrowTest(){
        doThrow(new RuntimeException("boom")).when(specialityRepository).delete(any());

        assertThrows(RuntimeException.class,()->specialityRepository.delete( new Speciality()));

        verify(specialityRepository).delete(any());
    }
    @Test
    void doThrowsTestBDD(){
        given(specialityRepository.findById(anyLong())).willThrow(new RuntimeException("boom"));

        assertThrows(RuntimeException.class,()->specialityRepository.findById(anyLong()));

        then(specialityRepository).should().findById(anyLong());
    }
    @Test
    void testSaveLambdaMatch(){
        final String MATCH_ME ="Match me";
        Speciality speciality = new Speciality();
        speciality.setDescription(MATCH_ME);

        Speciality savedSpeciality = new Speciality();
        savedSpeciality.setId(1L);

        given(specialityRepository.save(argThat(argument -> argument.getDescription().equals(MATCH_ME)))).willReturn(savedSpeciality);

        Speciality returnedSpeciality = specialityRepository.save(speciality);

        assertThat(returnedSpeciality.getId()).isEqualTo(1L);

    }
    @Test
    void testSaveLambdaDoNotMatch(){
        final String MATCH_ME ="Match me";
        Speciality speciality = new Speciality();
        speciality.setDescription("Does not match");

        Speciality savedSpeciality = new Speciality();
        savedSpeciality.setId(1L);

        given(specialityRepository.save(argThat(argument -> argument.getDescription().equals(MATCH_ME)))).willReturn(savedSpeciality);

        Speciality returnedSpeciality = specialityRepository.save(speciality);

        assertNull(returnedSpeciality);

    }
}