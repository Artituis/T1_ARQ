package br.arturslampert.sysctrlapp;

import br.arturslampert.sysctrlapp.aplicacao.dtos.AssinaturaDTO;
import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.AplicativoJPAEntity;
import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.AssinaturaJPAEntity;
import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.ClienteJPAEntity;
import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.repositories.AplicativoJPARepository;
import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.repositories.AssinaturaJPARepository;
import br.arturslampert.sysctrlapp.interfaceAdaptadora.persistencia.repositories.ClienteJPARepository;
import br.arturslampert.sysctrlapp.negocio.servicos.AssinaturaService;
import br.arturslampert.sysctrlapp.negocio.servicos.interfaces.AssinaturaServiceInterface;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Calendar;

@Component
@RequiredArgsConstructor
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final AplicativoJPARepository aplicativoJPARepository;
    private final ClienteJPARepository clienteJPARepository;
    private final AssinaturaJPARepository assinaturaJPARepository;
    private final AssinaturaServiceInterface assinaturaService;
    boolean alreadySetup = false;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup)
            return;
        setup();
        alreadySetup = true;
    }

    void setup() {
        createAplicativos();
        createClientes();
        createAssinaturas();
    }

    void createAplicativos() {
        AplicativoJPAEntity aplicativoJPAEntity = AplicativoJPAEntity.builder()
                .codigo(1L)
                .custoMensal(10.0F)
                .nome("Spotify")
                .build();
        aplicativoJPARepository.save(aplicativoJPAEntity);

        aplicativoJPAEntity = AplicativoJPAEntity.builder()
                .codigo(2L)
                .custoMensal(20.0F)
                .nome("Netflix")
                .build();
        aplicativoJPARepository.save(aplicativoJPAEntity);

        aplicativoJPAEntity = AplicativoJPAEntity.builder()
                .codigo(3L)
                .custoMensal(30.0F)
                .nome("Amazon Prime")
                .build();
        aplicativoJPARepository.save(aplicativoJPAEntity);

        aplicativoJPAEntity = AplicativoJPAEntity.builder()
                .codigo(4L)
                .custoMensal(40.0F)
                .nome("HBO Max")
                .build();
        aplicativoJPARepository.save(aplicativoJPAEntity);

        aplicativoJPAEntity = AplicativoJPAEntity.builder()
                .codigo(5L)
                .custoMensal(50.0F)
                .nome("Disney+")
                .build();
        aplicativoJPARepository.save(aplicativoJPAEntity);

        aplicativoJPAEntity = AplicativoJPAEntity.builder()
                .codigo(6L)
                .custoMensal(60.0F)
                .nome("Globo Play")
                .build();
        aplicativoJPARepository.save(aplicativoJPAEntity);

        aplicativoJPAEntity = AplicativoJPAEntity.builder()
                .codigo(7L)
                .custoMensal(70.0F)
                .nome("Telecine")
                .build();
        aplicativoJPARepository.save(aplicativoJPAEntity);

        aplicativoJPAEntity = AplicativoJPAEntity.builder()
                .codigo(8L)
                .custoMensal(80.0F)
                .nome("Paramount+")
                .build();
        aplicativoJPARepository.save(aplicativoJPAEntity);
    }

    void createClientes() {
        ClienteJPAEntity clienteJPAEntity = ClienteJPAEntity.builder()
                .codigo(1L)
                .nome("Artur")
                .email("artur@email.com")
                .build();
        clienteJPARepository.save(clienteJPAEntity);

        clienteJPAEntity = ClienteJPAEntity.builder()
                .codigo(2L)
                .nome("Lucas")
                .email("lucas@email.com")
                .build();
        clienteJPARepository.save(clienteJPAEntity);

        clienteJPAEntity = ClienteJPAEntity.builder()
                .codigo(3L)
                .nome("João")
                .email("joao@email.com")
                .build();
        clienteJPARepository.save(clienteJPAEntity);

        clienteJPAEntity = ClienteJPAEntity.builder()
                .codigo(4L)
                .nome("Maria")
                .email("maria@email.com")
                .build();
        clienteJPARepository.save(clienteJPAEntity);

        clienteJPAEntity = ClienteJPAEntity.builder()
                .codigo(5L)
                .nome("Ana")
                .email("ana@email.com")
                .build();
        clienteJPARepository.save(clienteJPAEntity);

        clienteJPAEntity = ClienteJPAEntity.builder()
                .codigo(6L)
                .nome("Pedro")
                .email("pedro@email.com")
                .build();
        clienteJPARepository.save(clienteJPAEntity);

        clienteJPAEntity = ClienteJPAEntity.builder()
                .codigo(7L)
                .nome("Paulo")
                .email("paulo@email.com")
                .build();
        clienteJPARepository.save(clienteJPAEntity);

        clienteJPAEntity = ClienteJPAEntity.builder()
                .codigo(8L)
                .nome("Carlos")
                .email("carlos@email.com")
                .build();
        clienteJPARepository.save(clienteJPAEntity);

        clienteJPAEntity = ClienteJPAEntity.builder()
                .codigo(9L)
                .nome("Mariana")
                .email("mariana@email.com")
                .build();
        clienteJPARepository.save(clienteJPAEntity);

        clienteJPAEntity = ClienteJPAEntity.builder()
                .codigo(10L)
                .nome("Julia")
                .email("julia@email.com")
                .build();
        clienteJPARepository.save(clienteJPAEntity);
    }

    void createAssinaturas() {
        AssinaturaDTO assinaturaDTO = AssinaturaDTO.builder()
                .codAplicativo(1L)
                .codCliente(1L)
                .build();
        assinaturaService.create(assinaturaDTO);

        assinaturaDTO = AssinaturaDTO.builder()
                .codAplicativo(2L)
                .codCliente(2L)
                .build();
        assinaturaService.create(assinaturaDTO);

        assinaturaDTO = AssinaturaDTO.builder()
                .codAplicativo(3L)
                .codCliente(3L)
                .build();
        assinaturaService.create(assinaturaDTO);

        assinaturaDTO = AssinaturaDTO.builder()
                .codAplicativo(4L)
                .codCliente(4L)
                .build();
        assinaturaService.create(assinaturaDTO);

        AssinaturaJPAEntity assinaturaCancelada = AssinaturaJPAEntity.builder()
                .aplicativo(aplicativoJPARepository.findById(5L).get())
                .cliente(clienteJPARepository.findById(5L).get())
                .inicioVigencia(getDateOneMonthBefore())
                .fimVigencia(getDateThreeWeeksBefore())
                .build();
        assinaturaJPARepository.save(assinaturaCancelada);
    }

    private Date getDateOneMonthBefore() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        return new Date(calendar.getTimeInMillis());
    }

    private Date getDateThreeWeeksBefore() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.WEEK_OF_YEAR, -3);
        return new Date(calendar.getTimeInMillis());
    }
}
