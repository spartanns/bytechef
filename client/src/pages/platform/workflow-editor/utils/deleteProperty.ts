import {
    DeleteWorkflowNodeParameter200ResponseModelI,
    DeleteWorkflowNodeParameterRequestI,
} from '@/pages/platform/workflow-editor/providers/workflowNodeParameterMutationProvider';

export default function deleteProperty(
    workflowId: string,
    path: string,
    currentComponent: ComponentType,
    setCurrentComponent: (currentComponent: ComponentType) => void,
    deleteWorkflowNodeParameterMutation: UseMutationResult<
        DeleteWorkflowNodeParameter200ResponseModelI,
        Error,
        DeleteWorkflowNodeParameterRequestI,
        unknown
    >
) {
    const {workflowNodeName} = currentComponent;

    deleteWorkflowNodeParameterMutation.mutate(
        {
            deleteWorkflowNodeParameterRequestModel: {
                path,
                workflowNodeName,
            },
            id: workflowId,
        },
        {
            onSuccess: (response) =>
                setCurrentComponent({
                    ...currentComponent,
                    parameters: response.parameters,
                }),
        }
    );
}

import {ComponentType} from '@/shared/types';
import {UseMutationResult} from '@tanstack/react-query';
