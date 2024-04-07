package com.carlosjr.backproposal.proposal;

import com.carlosjr.backproposal.user.User;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-07T16:46:39-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Amazon.com Inc.)"
)
@Component
class ProposalMapperImpl implements ProposalMapper {

    @Override
    public ProposalDto entityToDto(Proposal proposal) {
        if ( proposal == null ) {
            return null;
        }

        String name = null;
        String lastName = null;
        String cpf = null;
        String phone = null;
        Double rent = null;
        UUID id = null;
        Double requestValue = null;
        Integer paymentTerm = null;
        Boolean approved = null;
        String obs = null;

        name = proposalUserName( proposal );
        lastName = proposalUserLastName( proposal );
        cpf = proposalUserCpf( proposal );
        phone = proposalUserPhone( proposal );
        rent = proposalUserRent( proposal );
        id = proposal.getId();
        requestValue = proposal.getRequestValue();
        paymentTerm = proposal.getPaymentTerm();
        approved = proposal.getApproved();
        obs = proposal.getObs();

        ProposalDto proposalDto = new ProposalDto( id, name, lastName, phone, cpf, rent, requestValue, paymentTerm, approved, obs );

        return proposalDto;
    }

    @Override
    public Proposal dtoToEntity(ProposalDto proposalDto) {
        if ( proposalDto == null ) {
            return null;
        }

        Proposal proposal = new Proposal();

        proposal.setUser( proposalDtoToUser( proposalDto ) );
        proposal.setRequestValue( proposalDto.requestValue() );
        proposal.setPaymentTerm( proposalDto.paymentTerm() );
        proposal.setApproved( proposalDto.approved() );
        proposal.setObs( proposalDto.obs() );

        proposal.setIntegrated( true );

        return proposal;
    }

    private String proposalUserName(Proposal proposal) {
        if ( proposal == null ) {
            return null;
        }
        User user = proposal.getUser();
        if ( user == null ) {
            return null;
        }
        String name = user.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String proposalUserLastName(Proposal proposal) {
        if ( proposal == null ) {
            return null;
        }
        User user = proposal.getUser();
        if ( user == null ) {
            return null;
        }
        String lastName = user.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    private String proposalUserCpf(Proposal proposal) {
        if ( proposal == null ) {
            return null;
        }
        User user = proposal.getUser();
        if ( user == null ) {
            return null;
        }
        String cpf = user.getCpf();
        if ( cpf == null ) {
            return null;
        }
        return cpf;
    }

    private String proposalUserPhone(Proposal proposal) {
        if ( proposal == null ) {
            return null;
        }
        User user = proposal.getUser();
        if ( user == null ) {
            return null;
        }
        String phone = user.getPhone();
        if ( phone == null ) {
            return null;
        }
        return phone;
    }

    private Double proposalUserRent(Proposal proposal) {
        if ( proposal == null ) {
            return null;
        }
        User user = proposal.getUser();
        if ( user == null ) {
            return null;
        }
        Double rent = user.getRent();
        if ( rent == null ) {
            return null;
        }
        return rent;
    }

    protected User proposalDtoToUser(ProposalDto proposalDto) {
        if ( proposalDto == null ) {
            return null;
        }

        User user = new User();

        user.setName( proposalDto.name() );
        user.setLastName( proposalDto.lastName() );
        user.setCpf( proposalDto.cpf() );
        user.setPhone( proposalDto.phone() );
        user.setRent( proposalDto.rent() );

        return user;
    }
}
