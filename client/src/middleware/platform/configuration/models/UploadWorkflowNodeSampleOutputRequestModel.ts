/* tslint:disable */
/* eslint-disable */
/**
 * The Platform Configuration API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
/**
 * 
 * @export
 * @interface UploadWorkflowNodeSampleOutputRequestModel
 */
export interface UploadWorkflowNodeSampleOutputRequestModel {
    /**
     * 
     * @type {{ [key: string]: any; }}
     * @memberof UploadWorkflowNodeSampleOutputRequestModel
     */
    sampleOutput?: { [key: string]: any; };
}

/**
 * Check if a given object implements the UploadWorkflowNodeSampleOutputRequestModel interface.
 */
export function instanceOfUploadWorkflowNodeSampleOutputRequestModel(value: object): boolean {
    let isInstance = true;

    return isInstance;
}

export function UploadWorkflowNodeSampleOutputRequestModelFromJSON(json: any): UploadWorkflowNodeSampleOutputRequestModel {
    return UploadWorkflowNodeSampleOutputRequestModelFromJSONTyped(json, false);
}

export function UploadWorkflowNodeSampleOutputRequestModelFromJSONTyped(json: any, ignoreDiscriminator: boolean): UploadWorkflowNodeSampleOutputRequestModel {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        
        'sampleOutput': !exists(json, 'sampleOutput') ? undefined : json['sampleOutput'],
    };
}

export function UploadWorkflowNodeSampleOutputRequestModelToJSON(value?: UploadWorkflowNodeSampleOutputRequestModel | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        
        'sampleOutput': value.sampleOutput,
    };
}

