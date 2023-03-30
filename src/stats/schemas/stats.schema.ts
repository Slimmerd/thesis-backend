import { Prop, Schema, SchemaFactory } from '@nestjs/mongoose';
import { HydratedDocument } from 'mongoose';

export type StatsDocument = HydratedDocument<Stats>;

@Schema()
export class Stats {
    @Prop()
    readonly uID: String;
    @Prop()
    readonly stage: String;
    @Prop()
    readonly ordersInStage: String;
    @Prop()
    readonly actions: Array<String>
}

export const StatsSchema = SchemaFactory.createForClass(Stats);