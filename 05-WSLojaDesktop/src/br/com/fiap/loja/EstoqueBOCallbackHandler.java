
/**
 * EstoqueBOCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package br.com.fiap.loja;

    /**
     *  EstoqueBOCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class EstoqueBOCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public EstoqueBOCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public EstoqueBOCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for hasProduto method
            * override this method for handling normal response from hasProduto operation
            */
           public void receiveResulthasProduto(
                    br.com.fiap.loja.EstoqueBOStub.HasProdutoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from hasProduto operation
           */
            public void receiveErrorhasProduto(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for consultarProduto method
            * override this method for handling normal response from consultarProduto operation
            */
           public void receiveResultconsultarProduto(
                    br.com.fiap.loja.EstoqueBOStub.ConsultarProdutoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from consultarProduto operation
           */
            public void receiveErrorconsultarProduto(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cadastrarProduto method
            * override this method for handling normal response from cadastrarProduto operation
            */
           public void receiveResultcadastrarProduto(
                    br.com.fiap.loja.EstoqueBOStub.CadastrarProdutoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cadastrarProduto operation
           */
            public void receiveErrorcadastrarProduto(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for nextCodigo method
            * override this method for handling normal response from nextCodigo operation
            */
           public void receiveResultnextCodigo(
                    br.com.fiap.loja.EstoqueBOStub.NextCodigoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from nextCodigo operation
           */
            public void receiveErrornextCodigo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for listar method
            * override this method for handling normal response from listar operation
            */
           public void receiveResultlistar(
                    br.com.fiap.loja.EstoqueBOStub.ListarResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from listar operation
           */
            public void receiveErrorlistar(java.lang.Exception e) {
            }
                


    }
    