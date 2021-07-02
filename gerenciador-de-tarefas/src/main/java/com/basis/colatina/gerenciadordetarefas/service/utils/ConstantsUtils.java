package com.basis.colatina.gerenciadordetarefas.service.utils;

public class ConstantsUtils {
  public static final Long SITUATION_PENDING = 1L;
  public static final Long SITUATION_ACCEPTED = 2L;
  public static final Long SITUATION_REFUSED = 3L;


  // User validation Messages
  public static final String USER_BIRTH_DATE_NOT_NULL = "Data de nascimento é obrigatoria!";
  public static final String USER_BIRTH_DATE_PAST = "Data de nascimento deve ser uma data passada!";

  public static final String USER_NAME_NOT_EMPTY = "Nome não pode ser vazio!";
  public static final String USER_NAME_NOT_NULL = "Nome é obrigatorio!";

  public static final String USER_EMAIL_NOT_EMPTY = "Email é obrigatorio!";
  public static final String USER_EMAIL_NOT_NULL = "Email não pode ser vazio!";
  public static final String USER_EMAIL_FORMART = "Email em formato inválido!";

  public static final String USER_CPF_NOT_EMPTY = "Cpf é obrigatorio!";
  public static final String USER_CPF_NOT_NULL = "Cpf não pode ser vazio!";
  public static final String USER_CPF_FORMART = "Cpf em formato inválido!";

  public static final String USER_CPF_DUPLICATE = "Cpf já cadastrado no sistema!";
  public static final String USER_EMAIL_DUPLICATE = "Email já cadastrado no sistema!";
  public static final String USER_NOT_FOUND = "Nenhum Usuário encontrado!";

  // Offer validation Messages

  public static final String OFFER_ITEM_NOT_NULL = "Item da Oferta é obrigatorio!";
  public static final String OFFER_USER_NOT_NULL = "Usuario da Oferta é obrigatorio!";

  public static final String OFFER_ITEMS_OFFERED_NOT_NULL = "Itens ofertados são obrigatorios!";
  public static final String OFFER_ITEMS_OFFERED_NOT_EMPTY = "É necessário ao menos 1 item ofertado para criar uma oferta!";
  public static final String OFFER_NOT_FOUND = "Nenhuma Oferta encontrada!";
  public static final String ITEM_NOT_AVAILABLE = "Item não disponivel!";


  //Item validation Messages
  public static final String ITEM_NAME_NOT_NULL = "Campo nome não pode ser nulo";
  public static final String ITEM_NAME_NOT_EMPITY = "Campo nome não pode estar vazio";
  public static final String ITEM_AVALICAO_NOT_NULL = "Campo disponibilidade não pode ser nulo";
  public static final String ITEM_DESCRICAO_NOT_NULL = "Campo descrição não pode ser nulo";
  public static final String ITEM_DESCRICAO_NOT_EMPITY = "Campo descrição não pode estar vazio";
  public static final String ITEM_CATEGORIA_NOT_NULL = "Campo categoria não pode ser nulo";
  public static final String ITEM_USER_NOT_NULL = "Campo Usuário não pode ser nulo";
}
