package com.gustavonascimento.projetoSpring.entities.enums;

public enum StatusDoPedido {
	
	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int code;
	
	private StatusDoPedido(int code)
	{
		this.code=code;
	}
	
	public int getCode()
	{
		return code;
	}
	public static StatusDoPedido pegaValorETransformaEmStatus(int code)
	{
		for(StatusDoPedido valor: StatusDoPedido.values())
		{
			if(valor.getCode()==code)
			{
				return valor;
			}
		}
		throw new IllegalArgumentException("Código de status inválido");
	}
}
