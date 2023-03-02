import { Prop, Schema, SchemaFactory } from '@nestjs/mongoose';
import { HydratedDocument } from 'mongoose';

export type StatsDocument = HydratedDocument<Stats>;

@Schema()
export class Stats {
    @Prop()
    createdAt: Date;

    @Prop({type: Object})
    jsonData: Object;
}

export const StatsSchema = SchemaFactory.createForClass(Stats);