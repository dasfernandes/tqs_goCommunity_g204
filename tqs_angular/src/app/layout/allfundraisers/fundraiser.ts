import {User} from './user';

export class Fundraiser{
    id: number;
    title : string;
    description: string;
    goal: number;
    current: number;
    user: User;
}
