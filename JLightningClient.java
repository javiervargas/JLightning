/* Copyright Javier Vargas 2019  */


public class JLightningClient {

	JLightningRpc rpc_interface;
	String rpcfile;

	public JLightningClient(String rpcfile){
		this.rpcfile = rpcfile;		
	}

	protected String processCommand(String query){
		if(query.equalsIgnoreCase("getinfo")){
			return getInfo();
		}else		
		if(query.equalsIgnoreCase("listfunds")){
                        return getListFunds();
                }else
		if(query.equalsIgnoreCase("listinvoices")){
                        return getListInvoices();
                }else return "";	
	}

	public void getConnection(){
		rpc_interface = new JLightningRpc(this.rpcfile);
	}

	public String getInfo(){
		return rpc_interface.getInfo();
	}

	public String getListInvoices(){
		return rpc_interface.listInvoices(null);
	}

	public String getListFunds(){
		return rpc_interface.listFunds();
	}
	
	public static void main(String[] args) {
		JLightningRpc rpc_interface = new JLightningRpc("/home/ubuntu/.lightning/lightning-rpc");
		String res = rpc_interface.getInfo();
		System.out.println(res);

	}
}
