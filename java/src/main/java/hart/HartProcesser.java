package hart;

public class HartProcesser {

    public HartCommand getCmdProcessCommand(HartCommandBuffer buffer) {
        HartCommand retVal = HartCommand.PROCESS_ERR_OTHER;
        CommandDescriptor commandDescriptor = new CommandDescriptor();
        int uiCommandID = 0;

        // Try to extract the command ID from the received frame
        retVal = getReceivedCommandID(buffer, uiCommandID);
        if (retVal == HartCommand.PROCESS_OK) {

            // Try to get a command descriptor for this command ID
            retVal = getCommandDescriptor(buffer, uiCommandID, commandDescriptor);
            if (retVal == HartCommand.PROCESS_OK) {

                // Check the supported address range
                retVal = checkAddressValidity(buffer, commandDescriptor);
                if (retVal == HartCommand.PROCESS_OK) {

                    // Check that the received data size matches the expected
                    retVal = checkReceivedDataSize(buffer, commandDescriptor);
                    if (retVal == HartCommand.PROCESS_OK) {
                        retVal = commandDescriptor.processFunction(buffer);
                    }
                }
            }
        }
        return retVal;
    }

    private HartCommand checkReceivedDataSize(HartCommandBuffer buffer, CommandDescriptor commandDescriptor) {
        // TODO: something here
        return HartCommand.PROCESS_OK;
    }

    private HartCommand checkAddressValidity(HartCommandBuffer buffer, CommandDescriptor commandDescriptor) {
        // TODO: make call to external service
        return HartCommand.PROCESS_OK;
    }

    private HartCommand getCommandDescriptor(HartCommandBuffer buffer, int uiCommandID, CommandDescriptor commandDescriptor) {
        // TODO: something here
        return HartCommand.PROCESS_OK;
    }

    private HartCommand getReceivedCommandID(HartCommandBuffer buffer, int uiCommandID) {
        // TODO: something here
        return HartCommand.PROCESS_OK;
    }
}
